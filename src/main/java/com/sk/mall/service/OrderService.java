package com.sk.mall.service;

import com.sk.mall.entity.Order;
import com.sk.mall.entity.OrderItem;

import java.util.List;


/**
 * @author qiaochx
 */
public interface OrderService {
    void insertOrder(Order order);

    /**
     * 删除订单
     *
     * @param orderId 订单id
     */
    void deleteById(Integer orderId);

    List<Order> getAllByState(Order order);

    //
//
//     List<Order> selectOrderByExample(OrderExample orderExample);
//
//     List<Order> queryAllOrderByUserId(int userId);
//
//     List<OrderItem> getOrderItemByExample(OrderItemExample orderItemExample);
//
//     Address getAddressByKey(Integer addressid);
//
    void updateOrderByKey(Order order);

    //
    Order getById(int orderId);

    void insertOrderItem(OrderItem orderItem);

    /**
     * 根据用户id查找订单
     *
     * @param userId 用户id
     * @return 订单列表
     */
    List<Order> getAllByUserId(int userId);


    List<Order> getSendOrderByUserId(Integer id);

    List<Order> getReceiveOrderByUserId(Integer id);

    List<Order> getCompleteOrderByUserId(Integer id);

    List<Order> getSearchByGoodsName(Integer id,String keyword);
}
