package com.sk.mall.controller.admin;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sk.mall.entity.Admin;
import com.sk.mall.entity.Order;
import com.sk.mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/order")
public class AdminOrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/send")
    public String sendOrder(@RequestParam(value = "page", defaultValue = "1") Integer pn, Model model, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin == null) {
            return "redirect:/admin/login";
        }
        //一页显示几个数据
        PageHelper.startPage(pn, 2);
        //查询未发货订单
        Order order = new Order();
        order.setIsSend(false);
        List<Order> orderList = orderService.getAllByState(order);
        model.addAttribute("sendOrder", orderList);
        //显示几个页号
        PageInfo<Order> page = new PageInfo<>(orderList, 5);
        model.addAttribute("pageInfo", page);
        return "admin/adminAllOrder";
    }


    /**
     * 发货
     *
     * @param orderid 订单id
     * @param session session
     * @return String
     */
    @RequestMapping("/sendGoods")
    public String sendGoods(Integer orderid, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin == null) {
            return "redirect:/admin/login";
        }
        Order order = new Order();
        order.setId(orderid);
        order.setIsSend(true);
        orderService.updateOrderByKey(order);
        return "redirect:/admin/order/send";
    }

    /**
     * 查询未收货订单
     *
     * @param pn      页码
     * @param model   model
     * @param session session
     * @return String
     */
    @RequestMapping("/receiver")
    public String receiveOrder(@RequestParam(value = "page", defaultValue = "1") Integer pn, Model model, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin == null) {
            return "redirect:/admin/login";
        }
        //一页显示几个数据
        PageHelper.startPage(pn, 2);
        //查询未收货订单
        Order order = new Order();
        order.setIsSend(true);
        order.setIsReceive(false);
        List<Order> orderList = orderService.getAllByState(order);
        //显示几个页号
        PageInfo<Order> page = new PageInfo<>(orderList, 5);
        model.addAttribute("pageInfo", page);
        return "admin/adminOrderReceive";
    }


    /**
     * 已经接收的订单
     *
     * @param pn      页码
     * @param model   Model
     * @param session session
     * @return String
     */
    @RequestMapping("/complete")
    public String completeOrder(@RequestParam(value = "page", defaultValue = "1") Integer pn, Model model, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin == null) {
            return "redirect:/admin/login";
        }
        //一页显示几个数据
        PageHelper.startPage(pn, 2);

        //查询已完成订单
        Order order = new Order();
        order.setIsComplete(true);
        List<Order> orderList = orderService.getAllByState(order);
        model.addAttribute("sendOrder", orderList);
        //显示几个页号
        PageInfo<Order> page = new PageInfo<>(orderList, 5);
        model.addAttribute("pageInfo", page);
        return "admin/adminOrderComplete";
    }
}
