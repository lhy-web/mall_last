package com.sk.mall.service.impl;


import com.sk.mall.dao.FavoriteMapper;
import com.sk.mall.dao.GoodsMapper;
import com.sk.mall.entity.Favorite;
import com.sk.mall.entity.Goods;
import com.sk.mall.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {


    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public List<Goods> selectFavByUserId(Integer userId) {
        return goodsMapper.selectFavByUserId(userId);
    }

    //
//    @Autowired(required = false)
//    ImagePathMapper imagePathMapper;
//
    @Autowired(required = false)
    FavoriteMapper favoriteMapper;

    //
//    @Override
//    public Integer addGoods(Goods goods) {
//        goodsMapper.insertSelective(goods);
//        return goods.getGoodsid();
//    }
//
//    @Override
//    public void addImagePath(ImagePath imagePath) {
//        imagePathMapper.insertSelective(imagePath);
//    }
//

    @Override
    public List<Goods> getAllGoods() {
        return goodsMapper.getAllGoods();
    }

    //
//    @Override
//    public void deleteGoodsById(Integer goodsid) {
//        goodsMapper.deleteByPrimaryKey(goodsid);
//    }
//
//    @Override
//    public void updateGoodsById(Goods goods) {
//        goodsMapper.updateByPrimaryKeySelective(goods);
//    }
//
//    @Override
//    public List<ImagePath> findImagePath(Integer goodsid) {
//        ImagePathExample imagePathExample = new ImagePathExample();
//        imagePathExample.or().andGoodidEqualTo(goodsid);
//
//        return imagePathMapper.selectByExample(imagePathExample);
//    }
//
    @Override
    public Goods selectById(Integer goodsid) {
        return goodsMapper.getById(goodsid);
    }
//
//    @Override
//    public List<Goods> selectByExampleLimit(GoodsExample digGoodsExample) {
//        return goodsMapper.selectByExampleWithBLOBsLimit(digGoodsExample);
//    }
//

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
//
//    @Override
//    public List<Favorite> selectFavByExample(FavoriteExample favoriteExample) {
//        return favoriteMapper.selectByExample(favoriteExample);
//    }
}
