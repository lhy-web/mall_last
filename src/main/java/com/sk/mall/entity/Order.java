package com.sk.mall.entity;

import java.util.Date;
import java.util.List;

public class Order {

    private Integer id;

    private Integer userId;

    private Date orderTime;

    private Float oldPrice;

    private Float newPrice;

    private Boolean isPay;

    private Boolean issEnd;

    private Boolean isReceive;

    private Boolean isComplete;

    private Integer addressId;

    private List<OrderItem> orderItems;


    public Order() {
    }

    public Order(Integer id, Integer userId, Date orderTime, Float oldPrice, Float newPrice, Boolean isPay, Boolean issEnd, Boolean isReceive, Boolean isComplete, Integer addressId, List<OrderItem> orderItems) {
        this.id = id;
        this.userId = userId;
        this.orderTime = orderTime;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.isPay = isPay;
        this.issEnd = issEnd;
        this.isReceive = isReceive;
        this.isComplete = isComplete;
        this.addressId = addressId;
        this.orderItems = orderItems;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Float getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Float oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Float getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Float newPrice) {
        this.newPrice = newPrice;
    }

    public Boolean getPay() {
        return isPay;
    }

    public void setPay(Boolean pay) {
        isPay = pay;
    }

    public Boolean getIssEnd() {
        return issEnd;
    }

    public void setIssEnd(Boolean issEnd) {
        this.issEnd = issEnd;
    }

    public Boolean getReceive() {
        return isReceive;
    }

    public void setReceive(Boolean receive) {
        isReceive = receive;
    }

    public Boolean getComplete() {
        return isComplete;
    }

    public void setComplete(Boolean complete) {
        isComplete = complete;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderTime=" + orderTime +
                ", oldPrice=" + oldPrice +
                ", newPrice=" + newPrice +
                ", isPay=" + isPay +
                ", issEnd=" + issEnd +
                ", isReceive=" + isReceive +
                ", isComplete=" + isComplete +
                ", addressId=" + addressId +
                ", orderItems=" + orderItems +
                '}';
    }
}