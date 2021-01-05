package com.sk.mall.controller.admin;


import com.sk.mall.entity.Admin;
import com.sk.mall.service.AdminService;
import com.sk.mall.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private AdminService adminService;

    /**F
     * 返回到登录页面
     *
     * @return String
     */
    @RequestMapping("/login")
    public String adminLogin() {
        return "admin/adminLogin";
    }


    /**
     * 用户登录
     *
     * @param admin   用户名密码
     * @param model   存储前端返回值
     * @param request 获取session
     * @return String
     */
    @RequestMapping("/confirmLogin")
    public String confirmLogin(Admin admin, Model model, HttpServletRequest request) {
        admin.setPassword(Md5Util.MD5Encode(admin.getPassword(), "utf-8"));
        Admin selectAdmin = adminService.selectByName(admin);
        // 如果当前登录信息数据库中不存在，返回到登录页面，并重新登录
        if (selectAdmin == null) {
            model.addAttribute("errorMsg", "用户名或密码错误");
            return "admin/adminLogin";
        } else {
            // 如果存在，把用户信息存储在session中
            HttpSession session = request.getSession();
            session.setAttribute("admin", selectAdmin);
            return "redirect:/admin/goods/show";
        }
    }

    /**
     * 用户注销
     *
     * @param request 用来获取session
     * @return String
     */
    @RequestMapping("/logout")
    public String adminLogout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("admin");
        return "redirect:/admin/login";
    }

}
