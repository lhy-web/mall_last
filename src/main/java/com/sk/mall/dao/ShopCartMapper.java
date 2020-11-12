package com.sk.mall.dao;


import com.sk.mall.entity.ShopCart;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopCartMapper {

    int deleteByPrimaryKey(ShopCart key);

    int insertSelective(ShopCart record);

    List<ShopCart> getShopCartsByUserId(String userId);

    ShopCart selectByPrimaryKey(ShopCart key);

    int updateByPrimaryKeySelective(ShopCart record);

}