package com.sk.mall.service;

import com.sk.mall.entity.Comment;
import java.util.List;

/**
 * @author qiaochx
 */
public interface CommentService {

     void insertSelective(Comment comment);

     /**
      * 根据商品 id查评论
      *
      * @param goodsId 商品id
      * @return Comment
      */
     List<Comment> getByGoodsId(String goodsId);
}
