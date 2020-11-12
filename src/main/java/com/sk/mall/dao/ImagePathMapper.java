package com.sk.mall.dao;

import com.sk.mall.entity.ImagePath;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagePathMapper {

    int insertSelective(ImagePath record);

    List<ImagePath> getImagesByGoodsId(String goodsId);
}