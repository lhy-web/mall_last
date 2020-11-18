package com.sk.mall.dao;


import com.sk.mall.entity.OrderItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemMapper {
//    long countByExample(OrderItemExample example);
//
//    int deleteByExample(OrderItemExample example);

    int deleteByPrimaryKey(Integer itemid);

    int insertSelective(OrderItem record);

//    List<OrderItem> selectByExample(OrderItemExample example);

    OrderItem selectByPrimaryKey(Integer itemid);

//    int updateByExampleSelective(@Param("record") OrderItem record, @Param("example") OrderItemExample example);
//
//    int updateByExample(@Param("record") OrderItem record, @Param("example") OrderItemExample example);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

    /**
     * 根据订单id获取订单商品
     *
     * @param orderId order
     * @return List<OrderItem>
     */
    List<OrderItem> getOrderItemByOrderId(int orderId);
}