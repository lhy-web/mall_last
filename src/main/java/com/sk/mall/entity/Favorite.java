package com.sk.mall.entity;

import java.util.Date;

public class Favorite {

    private Integer userId;

    private Integer goodsId;

    private Date collectTime;

    public Favorite() {
    }

    public Favorite(Integer userId, Integer goodsId) {
        this.userId = userId;
        this.goodsId = goodsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "userId=" + userId +
                ", goodsId=" + goodsId +
                ", collectTime=" + collectTime +
                '}';
    }
}