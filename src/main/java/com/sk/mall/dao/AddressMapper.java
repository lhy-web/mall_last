package com.sk.mall.dao;

import com.sk.mall.entity.Address;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AddressMapper {
//    long countByExample(AddressExample example);
//
//    int deleteByExample(AddressExample example);

    int deleteByPrimaryKey(Integer addressid);

    int insert(Address record);

    int insertSelective(Address record);

//    List<Address> selectByExample(AddressExample example);

    Address selectByPrimaryKey(Integer addressid);

//    int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressExample example);
//
//    int updateByExample(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}