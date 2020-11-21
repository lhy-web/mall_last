package com.sk.mall.service;


import com.sk.mall.entity.Favorite;
import com.sk.mall.entity.Goods;
import com.sk.mall.entity.ImagePath;

import java.util.List;

public interface GoodsService {
    Integer addGoods(Goods goods);

    void addImagePath(ImagePath imagePath);

    List<Goods> getAllGoods();

    void deleteGoodsById(Integer id);

    void updateGoodsById(Goods goods);

    Goods selectById(Integer goodsId);

    List<Goods> getBySearchName(String keyWord);

    /**
     * 收藏商品
     *
     * @param favorite 商品
     */
    void addFavorite(Favorite favorite);

    Favorite selectFavByKey(Favorite favorite);


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


    /**
     * 根据分类名称模糊查询
     *
     * @param cate 用户id
     * @return List<Goods>
     */
    List<Goods> selectGoodsByCateLike(String cate);
}
