package com.sk.mall.dao;


import com.sk.mall.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
//    long countByExample(UserExample example);
//
//    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectAllUser();

    User selectByPrimaryKey(Integer userid);

//    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);
//
//    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}