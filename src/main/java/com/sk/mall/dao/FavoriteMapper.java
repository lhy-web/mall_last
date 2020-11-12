package com.sk.mall.dao;


import com.sk.mall.entity.Favorite;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteMapper {

    int deleteByPrimaryKey(Favorite key);

    int insertSelective(Favorite record);

    List<Favorite> getAllFavorite(String userId);

    Favorite selectByPrimaryKey(Favorite key);

}