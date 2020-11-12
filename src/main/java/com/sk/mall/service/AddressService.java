package com.sk.mall.service;

import com.sk.mall.entity.Address;
//import com.sk.mall.entity.AddressExample;

import java.util.List;

public interface AddressService {
//     List<Address> getAllAddressByExample(AddressExample addressExample);

     void updateByPrimaryKeySelective(Address address);

     void deleteByPrimaryKey(Integer addressid);

     void insert(Address address);

     void insertSelective(Address address);

     Address selectByPrimaryKey(Integer addressid);
}
