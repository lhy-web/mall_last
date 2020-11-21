package com.sk.mall.dao;


import com.sk.mall.entity.ShopCart;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qiaochx
 */
@Repository
public interface ShopCartMapper {

    /**
     * 删除购物车商品
     *
     * @param key 购物车
     * @return int
     */
    int deleteByPrimaryKey(ShopCart key);

    /**
     * 添加购物车
     *
     * @param record 购物车商品
     * @return int
     */
    int insertSelective(ShopCart record);

    /**
     * 查询一个人的所有购物车
     *
     * @param userId 用户id
     * @return List<ShopCart>
     */
    List<ShopCart> getShopCartsByUserId(int userId);

    /**
     * 查询具体购物车
     *
     * @param key 购物车信息
     * @return ShopCart
     */
    ShopCart selectByPrimaryKey(ShopCart key);

    /**
     * 更新购物车信息
     *
     * @param record 购物车二信息
     * @return int
     */
    int updateByPrimaryKeySelective(ShopCart record);

}