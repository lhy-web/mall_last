package com.sk.mall.dao;

import com.sk.mall.entity.ImagePath;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagePathMapper {

    int addImagePath(ImagePath record);


    /**
     * 查询商品的所有图片
     *
     * @param id 商品id
     * @return  List<ImagePath>
     */
    List<ImagePath> getImagesByGoodsId(String id);
}