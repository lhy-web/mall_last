package com.sk.mall.service;

import com.sk.mall.entity.User;

import java.util.List;

/**
 * @author qiaochx
 */
public interface UserService {
    /**
     * 根据主键查找
     *
     * @param userId 用户id
     * @return User
     */
    User selectByPrimaryKey(int userId);

    /**
     * 查询所有人员
     *
     * @param user 人员
     * @return List<User>
     */
    List<User> selectAllUser(User user);

    /**
     * 添加人员
     *
     * @param user 用户资料
     */
    void insertSelective(User user);

    /**
     * 根据主键删除
     *
     * @param userId 用户id
     */
    void deleteUserById(Integer userId);

    /**
     * 修改密码
     *
     * @param user 用户
     */
    void updateByPrimaryKeySelective(User user);

}
