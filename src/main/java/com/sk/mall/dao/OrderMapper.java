package com.sk.mall.dao;


import com.sk.mall.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    //    long countByExample(OrderExample example);
//
//    int deleteByExample(OrderExample example);
//
    int deleteById(Integer orderId);


    int insertSelective(Order record);

    //
//    List<Order> selectByExample(OrderExample example);
//
    Order getById(Integer orderid);

    //
//    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);
//
//    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);
//
    int updateByPrimaryKeySelective(Order record);
//
//    int updateByPrimaryKey(Order record);
//

    /**
     * 根据userId来查询所有的订单
     *
     * @param userId 用户id
     * @return List<Order>
     */
    List<Order> getAllOrderByUserId(int userId);

    List<Order> getAllByState(Order order);
}