package com.sk.mall.dao;


import com.sk.mall.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    /**
     * 根据主键删除
     *
     * @param userId 用户id
     * @return int
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * 添加人员
     *
     * @param user 用户资料
     * @return int
     */
    int insertSelective(User user);

    /**
     * 查询所有人员
     *
     * @param user 人员
     * @return List<User>
     */
    List<User> selectAllUser(User user);

    /**
     * 根据主键查找
     *
     * @param userId 用户id
     * @return User
     */
    User selectByPrimaryKey(Integer userId);

    /**
     * 修改用户资料
     *
     * @param user 用户资料
     * @return int
     */
    int updateByPrimaryKeySelective(User user);

}