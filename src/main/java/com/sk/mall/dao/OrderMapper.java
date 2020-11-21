package com.sk.mall.dao;


import com.sk.mall.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    /**
     * 删除订单
     *
     * @param orderId 订单id
     * @return int
     */
    int deleteById(Integer orderId);

    /**
     * 插入订单
     *
     * @param record 订单信息
     * @return int
     */
    int insertSelective(Order record);

    /**
     * 根据订单id查询订单
     *
     * @param orderId 订单id
     * @return Order
     */
    Order getById(Integer orderId);

    /**
     * 更新订单信息
     *
     * @param record 订单
     * @return int
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * 根据userId来查询所有的订单
     *
     * @param userId 用户id
     * @return List<Order>
     */
    List<Order> getAllOrderByUserId(int userId);

    /**
     * 根据订单状态查询
     *
     * @param order order
     * @return  List<Order>
     */
    List<Order> getAllByState(Order order);
}