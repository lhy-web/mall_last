package com.sk.mall.service;


import com.sk.mall.entity.Favorite;
import com.sk.mall.entity.Goods;

import java.util.List;

public interface GoodsService {
//    Integer addGoods(Goods goods);

//    void addImagePath(ImagePath imagePath);
//
//    List<Goods> selectByExample(GoodsExample example);

//    void deleteGoodsById(Integer goodsid);
//
//    void updateGoodsById(Goods goods);
//
//    List<ImagePath> findImagePath(Integer goodsid);
//
//    Goods selectById(Integer goodsid);
//
//    List<Goods> selectByExampleLimit(GoodsExample digGoodsExample);

    /**
     * 收藏商品
     *
     * @param favorite 商品
     */
    void addFavorite(Favorite favorite);
//
//    Favorite selectFavByKey(FavoriteKey favoriteKey);
//

    /**
     * 根据用户id、商品id删除收藏信息
     *
     * @param favorite 收藏信息
     */
    void deleteFavByKey(Favorite favorite);


    /**
     * 查找个人喜欢的商品
     *
     * @param userId 用户id
     * @return List<Goods>
     */
    List<Goods> selectFavByUserId(Integer userId);
}
