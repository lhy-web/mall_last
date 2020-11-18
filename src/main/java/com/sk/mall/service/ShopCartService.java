package com.sk.mall.service;


import com.sk.mall.entity.ShopCart;

import java.util.List;

public interface ShopCartService {
    void addShopCart(ShopCart shopCart);

    List<ShopCart> selectByExample(int userId);

    void deleteByKey(ShopCart shopCart);

    void updateCartByKey(ShopCart shopCart);

    ShopCart selectCartByKey(ShopCart shopCartKey);
}
