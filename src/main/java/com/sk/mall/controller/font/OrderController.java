package com.sk.mall.controller.font;


import com.sk.mall.entity.*;
import com.sk.mall.service.*;
import com.sk.mall.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class OrderController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private ShopCartService shopCartService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ActivityService activityService;

    @RequestMapping("/order")
    public String showOrder(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        //查询当前用户的收货地址
        List<Address> addressList = addressService.getAllAddressByUserId(user.getId());
        model.addAttribute("address", addressList);

        //订单信息
        //获取当前用户的购物车信息
        List<ShopCart> shopCart = shopCartService.selectByExample(user.getId());

        //获取购物车中的商品信息
        List<Goods> goodsAndImage = new ArrayList<>();

        float totalPrice = 0;
        int oldTotalPrice = 0;

        for (ShopCart cart : shopCart) {
            //分别从购物车列表中获取每个商品
            Goods goods = goodsService.selectById(cart.getGoodsId());
            goods.setNum(cart.getGoodsNum());

            //活动信息
            Activity activity = goods.getActivity();
            goods.setActivity(activity);

            //处理折扣信息
            //如果商品折扣不为1
            if (activity.getDisCount() != 1) {
                goods.setNewPrice(goods.getPrice() * goods.getNum() * activity.getDisCount());
                System.out.println("价格为：" + goods.getPrice() * goods.getNum() * activity.getDisCount());
            } else if (activity.getFullNum() != null) {
                System.out.println("进入第二层方法");
                if (goods.getNum() >= activity.getFullNum()) {
                    goods.setNewPrice((float) (goods.getPrice() * (goods.getNum() - activity.getReduceNum())));
                } else {
                    goods.setNewPrice((float) (goods.getPrice() * goods.getNum()));
                }
            } else if (activity.getFullPrice() != null && activity.getReduceNum() != null) {
                if ((goods.getNum() * goods.getNum()) > activity.getFullPrice()) {
                    goods.setNewPrice((float) (goods.getPrice() * goods.getNum() - activity.getReduceNum()));
                } else {
                    goods.setNewPrice((float) (goods.getPrice() * goods.getNum()));
                }

            } else {
                goods.setNewPrice((float) (goods.getPrice() * goods.getNum()));
            }
            totalPrice = totalPrice + goods.getNewPrice();
            oldTotalPrice = oldTotalPrice + goods.getNum() * goods.getPrice();
            goodsAndImage.add(goods);
        }
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("oldTotalPrice", oldTotalPrice);
        model.addAttribute("goodsAndImage", goodsAndImage);
        return "orderConfirm";
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/orderFinish")
    @ResponseBody
    public Msg orderFinish(Float oldPrice, Float newPrice, Boolean isPay, Integer addressid, HttpSession session) {
        User user = (User) session.getAttribute("user");

        //获取订单信息
        List<ShopCart> shopCart = shopCartService.selectByExample(user.getId());

        //删除购物车
        for (ShopCart cart : shopCart) {
            shopCartService.deleteByKey(new ShopCart(cart.getUserId(), cart.getGoodsId()));
        }

        //把订单信息写入数据库
        Order order = new Order(null, user.getId(), new Date(), oldPrice, newPrice, isPay, false, false, false, addressid, null, null);
        orderService.insertOrder(order);
        //插入的订单号
        Integer orderId = order.getId();

        //把订单项写入orderitem表中
        for (ShopCart cart : shopCart) {
            orderService.insertOrderItem(new OrderItem(null, orderId, cart.getGoodsId(), cart.getGoodsNum()));
        }

        return Msg.success("购买成功");
    }

}
