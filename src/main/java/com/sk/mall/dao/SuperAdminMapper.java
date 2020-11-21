package com.sk.mall.dao;

import com.sk.mall.entity.SuperAdmin;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperAdminMapper {

    /**
     * 查询超级管理员信息
     *
     * @param admin 管理员信息
     * @return com.sk.mall.entity.Admin
     **/
    SuperAdmin selectByUserNameAndPaaword(SuperAdmin admin);
}
