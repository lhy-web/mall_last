package com.sk.mall.dao;

import com.sk.mall.entity.Favorite;
import org.springframework.stereotype.Repository;

/**
 * @author qiaochx
 */
@Repository
public interface FavoriteMapper {

    /**
     * 根据主键删除收藏
     *
     * @param key 主键
     * @return int
     */
    int deleteByPrimaryKey(Favorite key);

    /**
     * 添加收藏
     *
     * @param record 收藏信息
     * @return int
     */
    int insertSelective(Favorite record);

    /**
     * 查找是否收藏了
     *
     * @param key 主键
     * @return Favorite
     */
    Favorite selectByPrimaryKey(Favorite key);

}