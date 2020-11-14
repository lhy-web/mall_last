package com.sk.mall.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sk.mall.entity.Admin;
import com.sk.mall.entity.Category;
import com.sk.mall.entity.Goods;
import com.sk.mall.service.CateService;
import com.sk.mall.service.GoodsService;
import com.sk.mall.util.ImageUtil;
import com.sk.mall.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/admin/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;


    @Autowired
    private CateService cateService;

    /**
     *  重定向当商品页
     *
     * @param model 存数据
     * @param session 取admin
     * @return String
     */
    @RequestMapping("/show")
    public String goodsManage(Model model, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin == null) {
            return "redirect:/admin/login";
        }
        // 把商品类型查询出来返回给前端，以供商品修改使用
        List<Category> categoryList = cateService.getAllCate();
        model.addAttribute("categoryList", categoryList);
        return "admin/adminAllGoods";
    }


    /**
     * 分页显示商品
     *
     * @param pn      页码
     * @param model   返回给前端的值
     * @param session session取admin
     * @return Msg
     */
    @RequestMapping("/showjson")
    @ResponseBody
    public Msg getAllGoods(@RequestParam(value = "page", defaultValue = "1") Integer pn, Model model, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin == null) {
            return Msg.fail("请先登录");
        }
        //一页显示几个数据
        PageHelper.startPage(pn, 10);
        List<Goods> goods = goodsService.getAllGoods();
        PageInfo<Goods> page = new PageInfo<>(goods, 5);
        model.addAttribute("pageInfo", page);
        return Msg.success("查询成功!").add("pageInfo", page);
    }
//
//
//    /**
//     * 添加商品回调函数
//     *
//     * @param msg 添加商品信息发返回值
//     * @param model 前端传值
//     * @param session 取admin，判断登录
//     * @return String
//     */
//    @RequestMapping("/add")
//    public String showAdd(@ModelAttribute("succeseMsg") String msg, Model model, HttpSession session) {
//        Admin admin = (Admin) session.getAttribute("admin");
//        if (admin == null) {
//            return "redirect:/admin/login";
//        }
//        if (!"".equals(msg)) {
//            model.addAttribute("msg", msg);
//        }
//        //还需要查询分类传给addGoods页面
//        List<Category> categoryList = cateService.selectByExample(new CategoryExample());
//        model.addAttribute("categoryList", categoryList);
//        return "admin/addGoods";
//    }
//
//    /**
//     * 修改商品
//     * @param goods 商品
//     * @param session 取admin
//     * @return Msg
//     */
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    @ResponseBody
//    public Msg updateGoods(Goods goods, HttpSession session) {
//        Admin admin = (Admin) session.getAttribute("admin");
//        if (admin == null) {
//            return Msg.fail("请先登录");
//        }
//        goodsService.updateGoodsById(goods);
//        return Msg.success("更新成功!");
//    }
//
//    /**
//     * 删除商品信息
//     * @param goodsid 商品id
//     * @return Msg
//     */
//    @RequestMapping(value = "/delete/{goodsid}", method = RequestMethod.DELETE)
//    @ResponseBody
//    public Msg deleteGoods(@PathVariable("goodsid") Integer goodsid) {
//        goodsService.deleteGoodsById(goodsid);
//        return Msg.success("删除成功!");
//    }
//
//    /**
//     * 添加商品，添加完成之后，重定向当添加商品页面
//     *
//     * @param goods 商品
//     * @param fileToUpload 文件
//     * @param redirectAttributes 重定向传递数据
//     * @return String
//     */
//    @RequestMapping("/addGoodsSuccess")
//    public String addGoods(Goods goods,
//                           @RequestParam MultipartFile[] fileToUpload,
//                           RedirectAttributes redirectAttributes) {
//        goods.setUptime(new Date());
//        goods.setActivityid(1);
//        goodsService.addGoods(goods);
//        for (MultipartFile multipartFile : fileToUpload) {
//            String fileName = goods.getGoodsname() + multipartFile.getOriginalFilename();
//            String imagePath = ImageUtil.imagePath(multipartFile, fileName);
//            //把图片路径存入数据库中
//            goodsService.addImagePath(new ImagePath(null, goods.getGoodsid(), imagePath));
//        }
//        redirectAttributes.addFlashAttribute("succeseMsg", "商品添加成功!");
//        return "redirect:/admin/goods/add";
//    }
//
//    /**
//     * 添加商品分类
//     *
//     * @param msg 分类信息
//     * @param model 返回给前端的数据
//     * @param session 取admin
//     * @return String
//     */
//    @RequestMapping("/addCategory")
//    public String addcategory(@ModelAttribute("succeseMsg") String msg, Model model, HttpSession session) {
//        Admin admin = (Admin) session.getAttribute("admin");
//        if (admin == null) {
//            return "redirect:/admin/login";
//        }
//        // 查询所有分类
//        List<Category> categoryList = cateService.selectByExample(new CategoryExample());
//        model.addAttribute("categoryList", categoryList);
//        if (!"".equals(msg)) {
//            model.addAttribute("msg", msg);
//        }
//        return "addCategory";
//    }
//
//    @Autowired
//    private CateService cateService;
//
//    @RequestMapping("/addCategoryResult")
//    public String addCategoryResult(Category category, RedirectAttributes redirectAttributes) {
//        CategoryExample categoryExample = new CategoryExample();
//        categoryExample.or().andCatenameEqualTo(category.getCatename());
//        List<Category> categoryList = cateService.selectByExample(categoryExample);
//        if (!categoryList.isEmpty()) {
//            redirectAttributes.addAttribute("succeseMsg", "分类已存在");
//            return "redirect:/admin/goods/addCategory";
//        } else {
//            cateService.insertSelective(category);
//            redirectAttributes.addFlashAttribute("succeseMsg", "分类添加成功!");
//            return "redirect:/admin/goods/addCategory";
//        }
//    }
//
//    /**
//     * 编辑分类
//     *
//     * @param category 分类
//     * @return Msg
//     */
//    @RequestMapping("/saveCate")
//    @ResponseBody
//    public Msg saveCate(Category category) {
//        CategoryExample categoryExample = new CategoryExample();
//        categoryExample.or().andCatenameEqualTo(category.getCatename());
//        List<Category> categoryList = cateService.selectByExample(categoryExample);
//        if (categoryList.isEmpty()) {
//            cateService.updateByPrimaryKeySelective(category);
//            return Msg.success("更新成功");
//        } else {
//            return Msg.success("名字已经存在");
//        }
//    }
//
//    /**
//     * 删除分类
//     * @param category 分类信息
//     * @return Msg
//     */
//    @RequestMapping("/deleteCate")
//    @ResponseBody
//    public Msg deleteCate(Category category) {
//        cateService.deleteByPrimaryKey(category.getCateid());
//        return Msg.success("删除成功");
//    }
}
