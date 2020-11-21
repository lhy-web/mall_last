package com.sk.mall.service.impl;


import com.sk.mall.dao.AddressMapper;
import com.sk.mall.entity.Address;
import com.sk.mall.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("addressService")
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    /**
     * 根据用户id 查询所有地址
     *
     * @param userId 用户id
     * @return List<Address>
     */
    @Override
    public List<Address> getAllAddressByUserId(Integer userId) {
        return addressMapper.getAllAddressByUserId(userId);
    }

    @Override
    public void updateByPrimaryKeySelective(Address address) {
        addressMapper.updateByPrimaryKeySelective(address);
    }

    @Override
    public void deleteByPrimaryKey(Integer addressid) {
        addressMapper.deleteByPrimaryKey(addressid);
    }


    @Override
    public void insertSelective(Address address) {
        addressMapper.insertSelective(address);
    }

    @Override
    public Address selectByPrimaryKey(Integer addressid) {
        return addressMapper.selectByPrimaryKey(addressid);
    }
}
