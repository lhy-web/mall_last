package com.sk.mall.service;

import com.sk.mall.entity.Activity;
import java.util.List;

/**
 * @author qiaochx
 */
public interface ActivityService {
    List<Activity> getAllActivity();

    void insertActivitySelective(Activity activity);

    Activity getActivityById(Integer activityid);

    void deleteByActivityId(Integer activityid);

}
