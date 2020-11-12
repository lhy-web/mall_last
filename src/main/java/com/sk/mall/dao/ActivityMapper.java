package com.sk.mall.dao;


import com.sk.mall.entity.Activity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityMapper {

    int deleteByPrimaryKey(Integer activityid);

    int insertSelective(Activity record);

    List<Activity> getAllActivity();

    Activity getActivityById(Integer id);
}