package com.sk.mall.dao;


import com.sk.mall.entity.ShopCart;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qiaochx
 */
@Repository
public interface ShopCartMapper {

    int deleteByPrimaryKey(ShopCart key);

    int insertSelective(ShopCart record);

    List<ShopCart> getShopCartsByUserId(int userId);

    ShopCart selectByPrimaryKey(ShopCart key);

    int updateByPrimaryKeySelective(ShopCart record);

}