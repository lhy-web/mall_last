package com.sk.mall.dao;

import com.sk.mall.entity.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressMapper {

    /**
     * 删除地址
     *
     * @param addressId 地址id
     * @return int
     */
    int deleteByPrimaryKey(Integer addressId);

    /**
     * 添加地址
     *
     * @param record 地址信息
     * @return int
     */
    int insertSelective(Address record);

    /**
     * 根据用户id 查询所有地址
     *
     * @param userId 用户id
     * @return List<Address>
     */
    List<Address> getAllAddressByUserId(Integer userId);

    /**
     * 根据id查询地址
     *
     * @param addressId 地址id
     * @return Address
     */
    Address selectByPrimaryKey(Integer addressId);

    /**
     * 修改地址
     *
     * @param record 地址
     * @return int
     */
    int updateByPrimaryKeySelective(Address record);


}