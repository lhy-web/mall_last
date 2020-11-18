package com.sk.mall.controller.font;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sk.mall.entity.Address;
import com.sk.mall.entity.Goods;
import com.sk.mall.entity.Order;
import com.sk.mall.entity.User;
import com.sk.mall.service.AddressService;
import com.sk.mall.service.GoodsService;
import com.sk.mall.service.OrderService;
import com.sk.mall.service.UserService;
import com.sk.mall.util.Md5Util;
import com.sk.mall.util.Msg;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class CustomerController {

    @RequestMapping("/login")
    public String loginView() {
        return "login";
    }

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/registerresult")
    public String registerResult(User user, Model registerResult) {
        user.setPassword(Md5Util.MD5Encode(user.getPassword(), "utf-8"));
        List<User> userList = userService.selectAllUser(new User(user.getUsername(), null));
        if (!userList.isEmpty()) {
            registerResult.addAttribute("errorMsg", "用户名被占用");
            return "register";
        } else {
            Date RegTime = new Date();
            user.setRegTime(RegTime);
            userService.insertSelective(user);
            return "redirect:/login";
        }
    }


    @RequestMapping("/loginconfirm")
    public String loginConfirm(User user, Model loginResult, HttpServletRequest request, @RequestParam("confirmlogo") String confirmlogo) {
        //进行用户密码MD5加密验证
        user.setPassword(Md5Util.MD5Encode(user.getPassword(), "UTF-8"));
        HttpSession session = request.getSession();
        String verificationCode = (String) session.getAttribute("certCode");
        if (!confirmlogo.equals(verificationCode)) {
            loginResult.addAttribute("errorMsg", "验证码错误");
            return "login";
        }
        List<User> userList = userService.selectAllUser(user);
        if (!userList.isEmpty()) {
            session.setAttribute("user", userList.get(0));
            return "redirect:/main";
        } else {
            loginResult.addAttribute("errorMsg", "用户名与密码不匹配");
            return "login";
        }
    }

    /**
     * 个人信息管理
     *
     * @param userModel 前端展示信息
     * @param request   用来获取session
     * @return String
     */
    @RequestMapping("/information")
    public String information(Model userModel, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Integer userId;
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        userId = user.getId();
        user = userService.selectByPrimaryKey(userId);
        userModel.addAttribute("user", user);
        return "person/information";
    }

    /**
     * 修改个人信息
     *
     * @param username  用户名
     * @param email     邮箱
     * @param telephone 手机号
     * @param request   用来获取session
     * @return Msg
     */
    @RequestMapping("/saveInfo")
    @ResponseBody
    public Msg saveInfo(String username, String email, String telephone, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user, updateUser = new User();
        user = (User) session.getAttribute("user");
        if (user == null) {
            return Msg.fail("请重新登录");
        }
        Integer userId = user.getId();
        List<User> userList = userService.selectAllUser(new User(username, null));
        if (userList.isEmpty()) {
            updateUser.setId(userId);
            updateUser.setUsername(username);
            updateUser.setEmail(email);
            updateUser.setTelephone(telephone);
            userService.updateByPrimaryKeySelective(updateUser);
            return Msg.success("更新成功");
        } else {
            return Msg.fail("更新失败");
        }
    }

    @Autowired
    private AddressService addressService;

    /**
     * 跳转地址页面
     *
     * @param request      request
     * @param addressModel Model
     * @return String
     */
    @RequestMapping("/info/address")
    public String address(HttpServletRequest request, Model addressModel) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        List<Address> addressList = addressService.getAllAddressByUserId(user.getId());
        addressModel.addAttribute("addressList", addressList);
        return "person/address";
    }

    /**
     * 修改地址
     *
     * @param address 地址信息
     * @return Msg
     */
    @RequestMapping("/saveAddr")
    @ResponseBody
    public Msg saveAddr(Address address) {
        addressService.updateByPrimaryKeySelective(address);
        return Msg.success("修改成功");
    }

    /**
     * 删除地址
     *
     * @param address 地址
     * @return Msg
     */
    @RequestMapping("/deleteAddr")
    @ResponseBody
    public Msg deleteAddr(Address address) {
        addressService.deleteByPrimaryKey(address.getId());
        return Msg.success("删除成功");
    }

    /**
     * 添加地址
     *
     * @param address address
     * @param request request
     * @return Msg
     */
    @RequestMapping("/insertAddr")
    @ResponseBody
    public Msg insertAddr(Address address, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        address.setUserId(user.getId());
        addressService.insertSelective(address);
        return Msg.success("添加成功");
    }

    @Autowired
    private OrderService orderService;

    @Autowired
    private GoodsService goodsService;

    /**
     * 查询订单
     *
     * @param request    HttpServletRequest
     * @param orderModel Model
     * @return String
     */
    @RequestMapping("/info/list")
    public String list(HttpServletRequest request, Model orderModel) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        List<Order> orderList = orderService.getAllByUserId(user.getId());
        orderModel.addAttribute("orderList", orderList);
        return "/person/list";
    }


    @RequestMapping("/deleteList")
    @ResponseBody
    public Msg deleteList(int orderId) {
        orderService.deleteById(orderId);
        return Msg.success("删除成功");
    }


    @RequestMapping("/info/favorite")
    @ApiOperation(value = "获取收藏商品", notes = "获取收藏商品")
    public String showFavorite(@RequestParam(value = "page", defaultValue = "1") Integer pn, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        //一页显示几个数据
        PageHelper.startPage(pn, 10);
        List<Goods> goodsList = goodsService.selectFavByUserId(user.getId());
        for (Goods goods : goodsList) {
            //判断是否收藏
            goods.setFav(true);
        }
        //显示几个页号
        PageInfo<Goods> page = new PageInfo<>(goodsList, 5);
        model.addAttribute("pageInfo", page);
        return "person/favorite";
    }

    @RequestMapping("/updatePassword")
    @ResponseBody
    public Msg savePsw(String password, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        user.setPassword(Md5Util.MD5Encode(password, "UTF-8"));
        userService.updateByPrimaryKeySelective(user);
        return Msg.success("修改密码成功");
    }

    @RequestMapping("/finishList")
    @ResponseBody
    public Msg finishiList(Integer orderid) {
        Order order = orderService.getById(orderid);
        order.setIsReceive(true);
        order.setIsComplete(true);
        orderService.updateOrderByKey(order);
        return Msg.success("完成订单成功");
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "redirect:/login";
    }

}
