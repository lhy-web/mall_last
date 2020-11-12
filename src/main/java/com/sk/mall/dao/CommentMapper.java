package com.sk.mall.dao;


import com.sk.mall.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {

    int insertSelective(Comment record);

    List<Comment> getByGoodsId(String goodsId);

}