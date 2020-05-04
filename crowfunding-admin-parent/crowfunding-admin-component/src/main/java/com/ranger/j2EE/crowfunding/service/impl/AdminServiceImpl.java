package com.ranger.j2EE.crowfunding.service.impl;

import com.ranger.j2EE.crowfunding.entity.Admin;
import com.ranger.j2EE.crowfunding.mapper.AdminMapper;
import com.ranger.j2EE.crowfunding.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    public void saveAdmin(Admin admin) {
        adminMapper.insert(admin);
    }
}
