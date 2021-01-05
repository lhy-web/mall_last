package com.sk.mall.dao;


import com.sk.mall.entity.Order;
import com.sk.mall.entity.OrderItem;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderItemMapper {


    /**
     * 删除子订单
     *
     * @param itemId 子订单id
     * @return int
     */
    int deleteByPrimaryKey(Integer itemId);

    /**
     * 新增订单
     *
     * @param record 订单信息
     * @return int
     */
    int insertSelective(OrderItem record);

    /**
     * 根据订单id查找订单
     *
     * @param itemid 订单id
     * @return OrderItem
     */
    OrderItem selectByPrimaryKey(Integer itemid);

    /**
     * 修改订单信息
     *
     * @param record 订单信息
     * @return int
     */
    int updateByPrimaryKeySelective(OrderItem record);

    /**
     * 根据订单id获取订单商品
     *
     * @param orderId order
     * @return List<OrderItem>
     */
    List<OrderItem> getOrderItemByOrderId(int orderId);

    List<Map<String, Object>> getTotalGoods();


}