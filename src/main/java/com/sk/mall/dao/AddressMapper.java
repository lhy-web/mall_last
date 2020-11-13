package com.sk.mall.dao;

import com.sk.mall.entity.Address;
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

    /**
     * 根据用户id 查询所有地址
     *
     * @param userId 用户id
     * @return List<Address>
     */
    List<Address> getAllAddressByUserId(Integer userId);

    Address selectByPrimaryKey(Integer addressId);

//    int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressExample example);
//
//    int updateByExample(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}