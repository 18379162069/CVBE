package com.cv.be.service.impl;

import com.cv.be.entity.Admin;
import com.cv.be.repository.AdminRepository;
import com.cv.be.service.AdminService;
import com.cv.be.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhou_wb on 2017/5/13.
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;
    @Override
    public List<Admin> findAdminById(Integer id) {
        List<Admin> admins = null;
        admins = adminRepository.findById(id);
        return admins;
    }

    @Override
    public Admin findAdminByAccount(String account) {
        Integer flag = CommonUtil.isEmailOrMobile(account);
        Admin admin = null;
        if (flag == 1) {
            admin = adminRepository.findByMobile(account);
        }
        if (flag == 2){
            admin = adminRepository.findByMobile(account);
        }
        return admin;
    }

    @Override
    public HttpStatus add(Admin admin) {
        Boolean flag = true;
        if (admin.getEmail() != null){
            flag = false;
            return HttpStatus.CONFLICT;
        }
        if (admin.getMobile() != null){
            flag = false;
            return HttpStatus.CONFLICT;
        }
        if (flag) {
            adminRepository.save(admin);
            return HttpStatus.OK;
        }
        return null;
    }

    @Override
    public HttpStatus update(Admin admin) {
        return null;
    }

    @Override
    public void delete(Admin admin) {

    }
}
