package com.sk.mall.service.impl;


import com.sk.mall.dao.FavoriteMapper;
import com.sk.mall.dao.GoodsMapper;
import com.sk.mall.dao.ImagePathMapper;
import com.sk.mall.entity.Category;
import com.sk.mall.entity.Favorite;
import com.sk.mall.entity.Goods;
import com.sk.mall.entity.ImagePath;
import com.sk.mall.service.CateService;
import com.sk.mall.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {


    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private CateService cateService;

    @Autowired
    private ImagePathMapper imagePathMapper;

    @Autowired
    private FavoriteMapper favoriteMapper;

    @Override
    public List<Goods> selectFavByUserId(Integer userId) {
        return goodsMapper.selectFavByUserId(userId);
    }


    @Override
    public Integer addGoods(Goods goods) {
        Category category = cateService.selectById(goods.getCategory());
        if (category != null) {
            goods.setCategoryName(category.getCateName());
        }
        goodsMapper.insertSelective(goods);
        return goods.getId();
    }

    @Override
    public void addImagePath(ImagePath imagePath) {
        imagePathMapper.addImagePath(imagePath);
    }


    @Override
    public List<Goods> getAllGoods() {
        return goodsMapper.getAllGoods();
    }


    @Override
    public void deleteGoodsById(Integer id) {
        goodsMapper.deleteById(id);
    }


    @Override
    public void updateGoodsById(Goods goods) {
        Category category = cateService.selectById(goods.getCategory());
        if (category != null) {
            goods.setCategoryName(category.getCateName());
        }
        goodsMapper.updateByPrimaryKeySelective(goods);
    }


    @Override
    public Goods selectById(Integer goodsid) {
        return goodsMapper.getById(goodsid);
    }

    @Override
    public List<Goods> getBySearchName(String keyWord) {
        return goodsMapper.getBySearchName("%" + keyWord + "%");
    }

    @Override
    public void addFavorite(Favorite favorite) {
        favoriteMapper.insertSelective(favorite);
    }

    @Override
    public Favorite selectFavByKey(Favorite favorite) {
        return favoriteMapper.selectByPrimaryKey(favorite);
    }


    @Override
    public void deleteFavByKey(Favorite favoriteKey) {
        favoriteMapper.deleteByPrimaryKey(favoriteKey);
    }


    @Override
    public List<Goods> selectGoodsByCateLike(String cate) {
        return goodsMapper.selectGoodsByCateLike("%" + cate + "%");
    }
}
