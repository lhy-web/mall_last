package com.sk.mall.service.impl;


import com.sk.mall.dao.AdminMapper;
import com.sk.mall.entity.Admin;
import com.sk.mall.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qiaochx
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin selectByName(Admin admin) {
        return adminMapper.selectByName(admin);
    }
}
