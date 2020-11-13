package com.sk.mall.service;

import com.sk.mall.entity.User;

import java.util.List;

/**
 * @author qiaochx
 */
public interface UserService {

    User selectByPrimaryKey(int userId);

    List<User> selectAllUser(User user);

    void insertSelective(User user);

    void deleteUserById(Integer userid);

    /**
     * 修改密码
     *
     * @param user 用户
     */
    void updateByPrimaryKeySelective(User user);

}
