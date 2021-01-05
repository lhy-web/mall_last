package com.sk.mall.controller.font;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sk.mall.entity.Comment;
import com.sk.mall.entity.Favorite;
import com.sk.mall.entity.Goods;
import com.sk.mall.entity.User;
import com.sk.mall.service.*;
import com.sk.mall.util.Msg;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FrontGoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CateService cateService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private ActivityService activityService;

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String detailGoods(Integer goodsid, Model model, HttpSession session) {
        if (goodsid == null) {
            return "redirect:/main";
        }
        User user = (User) session.getAttribute("user");

        //查询商品的基本信息
        Goods goods = goodsService.selectById(goodsid);
        if (user == null) {
            goods.setFav(false);
        } else {
            Favorite favorite = goodsService.selectFavByKey(new Favorite(user.getId(), goodsid));
            goods.setFav(favorite != null);
        }
        model.addAttribute("goods", goods);
        return "detail";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchGoods(@RequestParam(value = "page", defaultValue = "1") Integer pn, String keyword, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        //一页显示几个数据
        PageHelper.startPage(pn, 9);
        //查询数据
        List<Goods> goodsList = goodsService.getBySearchName(keyword);

        //获取图片地址
        for (Goods goods : goodsList) {
            //判断是否收藏
            if (user == null) {
                goods.setFav(false);
            } else {
                Favorite favorite = goodsService.selectFavByKey(new Favorite(user.getId(), goods.getId()));
                goods.setFav(favorite != null);
            }
        }
        //显示几个页号
        PageInfo page = new PageInfo(goodsList, 5);
        model.addAttribute("pageInfo", page);
        model.addAttribute("keyword", keyword);
        return "search";
    }

    @RequestMapping("/collect")
    @ResponseBody
    public Msg collectGoods(Integer goodsid, HttpSession session) {
        //取登录用户信息,未登录重定向至登录页面
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return Msg.fail("收藏失败");
        }
        //添加收藏
        Favorite favorite = new Favorite();
        favorite.setCollectTime(new Date());
        favorite.setGoodsId(goodsid);
        favorite.setUserId(user.getId());
        goodsService.addFavorite(favorite);
        return Msg.success("收藏成功");
    }

    @RequestMapping("/deleteCollect")
    @ResponseBody
    @ApiOperation(value = "取消收藏", notes = "取消收藏")
    public Msg deleteFavGoods(Integer goodsid, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return Msg.fail("取消收藏失败");
        }
        //删除收藏
        goodsService.deleteFavByKey(new Favorite(user.getId(), goodsid));
        return Msg.success("取消收藏成功");
    }


    @RequestMapping("/category")
    public String getCateGoods(String cate, @RequestParam(value = "page", defaultValue = "1") Integer pn, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        //一页显示几个数据
        PageHelper.startPage(pn, 16);
        List<Goods> goodsList = goodsService.selectGoodsByCateLike(cate);
        //获取是否收藏
        for (Goods goods : goodsList) {
            //判断是否收藏
            if (user == null) {
                goods.setFav(false);
            } else {
                Favorite favorite = goodsService.selectFavByKey(new Favorite(user.getId(), goods.getId()));
                goods.setFav(favorite != null);
            }
        }
        //显示几个页号
        PageInfo page = new PageInfo(goodsList, 5);
        model.addAttribute("pageInfo", page);
        model.addAttribute("cate", cate);
        return "category";
    }


    @RequestMapping("/comment")
    @ResponseBody
    public Msg comment(Comment comment, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return Msg.fail("评论失败");
        }
        comment.setUserId(user.getId());
        Date date = new Date();
        comment.setCommentTime(date);
        commentService.insertSelective(comment);
        return Msg.success("评论成功");
    }
}
