package com.sk.mall.service.impl;

import com.sk.mall.dao.ActivityMapper;
import com.sk.mall.entity.Activity;
import com.sk.mall.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("activityService")
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    ActivityMapper activityMapper;

    @Override
    public List<Activity> getAllActivity( ) {
        return activityMapper.getAllActivity();
    }

    @Override
    public void insertActivitySelective(Activity activity) {
        activityMapper.insertSelective(activity);
    }

    @Override
    public Activity getActivityById(Integer activityid) {
        return activityMapper.getActivityById(activityid);
    }

    @Override
    public void deleteByActivityId(Integer activityid) {
        activityMapper.deleteByPrimaryKey(activityid);
    }

}
