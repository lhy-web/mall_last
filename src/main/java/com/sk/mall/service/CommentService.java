package com.sk.mall.service;


import com.sk.mall.entity.Comment;

import java.util.List;

public interface CommentService {
     void insertSelective(Comment comment);

     List<Comment> getByGoodsId(String goodsId);
}
