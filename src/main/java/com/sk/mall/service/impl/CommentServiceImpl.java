package com.sk.mall.service.impl;


import com.sk.mall.dao.CommentMapper;
import com.sk.mall.entity.Comment;
import com.sk.mall.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Autowired(required = false)
    private CommentMapper commentMapper;

    @Override
    public void insertSelective(Comment comment) {
        commentMapper.insertSelective(comment);
    }

    @Override
    public List<Comment> getByGoodsId(String goodsId) {
        return commentMapper.getByGoodsId(goodsId);
    }

}
