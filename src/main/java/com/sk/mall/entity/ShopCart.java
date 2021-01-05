package com.sk.mall.entity;

import java.util.Date;

public class ShopCart {

    private Date cateDate;

    private Integer goodsNum;

    private Integer userId;

    private Integer goodsId;

    public ShopCart() {
    }

    public ShopCart(Integer userId, Integer goodsId) {
        this.userId = userId;
        this.goodsId = goodsId;
    }

    public Date getCateDate() {
        return cateDate;
    }

    public void setCateDate(Date cateDate) {
        this.cateDate = cateDate;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        if(goodsNum<1){
            goodsNum=1;
        }
        this.goodsNum = goodsNum;
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

    @Override
    public String toString() {
        return "ShopCart{" +
                "cateDate=" + cateDate +
                ", goodsNum=" + goodsNum +
                ", userId=" + userId +
                ", goodsId=" + goodsId +
                '}';
    }
}