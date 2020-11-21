package com.sk.mall.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sk.mall.entity.User;
import com.sk.mall.service.UserService;
import com.sk.mall.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/superadmin/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 显示用户管理页面
     *
     * @return String
     */
    @RequestMapping("/show")
    public String userManage() {
        return "superadmin/userManage";
    }


    /**
     * 查询所有用户
     *
     * @param pn 查询用户
     * @return Msg
     */
    @RequestMapping("/showjson")
    @ResponseBody
    public Msg getAllGoods(@RequestParam(value = "page", defaultValue = "1") Integer pn) {
        //一页显示几个数据
        PageHelper.startPage(pn, 10);
        List<User> userList = userService.selectAllUser(new User());
        //显示几个页号
        PageInfo<User> page = new PageInfo<>(userList, 5);
        return Msg.success("查询成功!").add("pageInfo", page);
    }


    /**
     * 删除用户
     *
     * @param userid 用 户id
     * @return Msg
     */
    @RequestMapping(value = "/delete/{userid}", method = RequestMethod.DELETE)
    @ResponseBody
    public Msg deleteUser(@PathVariable("userid") Integer userid) {
        userService.deleteUserById(userid);
        return Msg.success("删除成功!");
    }
}
