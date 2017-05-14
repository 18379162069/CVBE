package com.cv.be.service.impl;

import com.cv.be.entity.AdminRole;
import com.cv.be.repository.AdminRoleRepository;
import com.cv.be.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zhou_wb on 2017/5/14.
 */
public class AdminRoleServiceImpl implements AdminRoleService {

    @Autowired
    AdminRoleRepository adminRoleRepository;
    @Override
    public void deleteByAdminId(Integer adminId) {
        adminRoleRepository.deleteByAdminId(adminId);
    }

    @Override
    public AdminRole add(AdminRole adminRole) {
        AdminRole adminRole1 = null;
        if (adminRole.getAdminId() != null && adminRole.getRoleId() != null){
            adminRole1 = adminRoleRepository.findByAdminIdAndRoleId(adminRole.getAdminId()
                    ,adminRole.getRoleId());
            if (adminRole1 != null){
                return null;
            } else {
                adminRoleRepository.save(adminRole);
            }
        }
        return adminRole;
    }
}
