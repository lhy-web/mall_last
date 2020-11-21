package com.sk.mall.service.impl;

import com.sk.mall.dao.OrderItemMapper;
import com.sk.mall.dao.OrderMapper;
import com.sk.mall.entity.Order;
import com.sk.mall.entity.OrderItem;
import com.sk.mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;


    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public void insertOrder(Order order) {
        orderMapper.insertSelective(order);
    }

    @Override
    public void deleteById(Integer orderId) {
        orderMapper.deleteById(orderId);
    }

    @Override
    public List<Order> getAllByState(Order order) {
        return orderMapper.getAllByState(order);
    }

    @Override
    public void updateOrderByKey(Order order) {
        orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public Order getById(int orderId) {
        return orderMapper.getById(orderId);
    }

    @Override
    public void insertOrderItem(OrderItem orderItem) {
        orderItemMapper.insertSelective(orderItem);
    }

    @Override
    public List<Order> getAllByUserId(int userId) {
        return orderMapper.getAllOrderByUserId(userId);
    }
}
