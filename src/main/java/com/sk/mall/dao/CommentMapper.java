package com.sk.mall.dao;


import com.sk.mall.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {

    /**
     * 添加评论
     *
     * @param comment 评论
     * @return int
     */
    int insertSelective(Comment comment);

    /**
     * 根据商品查询评论
     *
     * @param goodsId 商品id
     * @return List<Comment>
     */
    List<Comment> getByGoodsId(String goodsId);


}