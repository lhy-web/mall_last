package com.sk.mall.service;

import com.sk.mall.entity.User;

import java.util.List;

public interface UserService {

    User selectByPrimaryKey(int userId);

    List<User> selectAllUser(User user);

    void insertSelective(User user);

    void deleteUserById(Integer userid);

    void updateByPrimaryKeySelective(User user);

}
