package com.sk.mall.controller.font;


import com.sk.mall.entity.Category;
import com.sk.mall.entity.Favorite;
import com.sk.mall.entity.Goods;
import com.sk.mall.entity.User;
import com.sk.mall.service.CateService;
import com.sk.mall.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private CateService cateService;

    @Autowired
    private GoodsService goodsService;


    @RequestMapping("/")
    public String showAdmin(Model model, HttpSession session) {
        Integer userId;
        User user = (User) session.getAttribute("user");
        if (user == null) {
            userId = null;
        } else {
            userId = user.getId();
        }
        //数码分类及商品
        List<Category> categories = cateService.getAllCate();
        for (Category category : categories) {
            List<Goods> digGoods = getCateGoods(category.getCateName(), userId);
            category.setGoods(digGoods);
        }
        List<Goods> hotGoods = this.goodsService.getHotGoods(4);
        model.addAttribute("categories", categories);
        model.addAttribute("hotGoods", hotGoods);
        return "main";
    }


    @RequestMapping("/main")
    public String showAllGoods(Model model, HttpSession session) {
        Integer userId;
        User user = (User) session.getAttribute("user");
        if (user == null) {
            userId = null;
        } else {
            userId = user.getId();
        }
        //数码分类及商品
        List<Category> categories = cateService.getAllCate();
        for (Category category : categories) {
            List<Goods> digGoods = getCateGoods(category.getCateName(), userId);
            category.setGoods(digGoods);
        }
        List<Goods> hotGoods = this.goodsService.getHotGoods(4);
        model.addAttribute("categories", categories);
        model.addAttribute("hotGoods", hotGoods);
        return "main";
    }

    public List<Goods> getCateGoods(String cate, Integer userid) {
        List<Goods> goodsList = goodsService.selectGoodsByCateLike(cate);
        //获取每个商品的图片
        for (Goods goods : goodsList) {
            //判断是否为登录状态
            if (userid == null) {
                goods.setFav(false);
            } else {
                Favorite favorite = goodsService.selectFavByKey(new Favorite(userid, goods.getId()));
                goods.setFav(favorite != null);
            }
        }
        return goodsList;
    }


}
