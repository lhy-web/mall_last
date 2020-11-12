package com.sk.mall.dao;

import com.sk.mall.entity.Admin;
import org.springframework.stereotype.Repository;


/**
 * @author qiaochx
 */
@Repository
public interface AdminMapper {

    /**
     * 查询管理员信息
     *
     * @param admin 管理员信息
     * @return com.sk.mall.entity.Admin
     * @date 2020/11/12
     * 修改人和其它信息：
     **/
    Admin selectByName(Admin admin);

}