package com.cv.be.service.impl;

import com.cv.be.entity.Admin;
import com.cv.be.repository.AdminRepository;
import com.cv.be.service.AdminService;
import com.cv.be.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
            admin = adminRepository.findByEmail(account);
        }
        return admin;
    }

    @Override
    public HttpStatus add(Admin admin) {
        Boolean flag = true;
        Admin admin1 = null;
        if (admin.getEmail() != null){
           admin1 = adminRepository.findByEmail(admin.getEmail());
            if (admin1 != null){
                flag = false;
                return HttpStatus.CONFLICT;
            }
        }
        if (admin.getMobile() != null){
            admin1 = adminRepository.findByMobile(admin.getMobile());
            if (admin1 != null){
                flag = false;
                return HttpStatus.CONFLICT;
            }
        }
        if (flag) {
            // todo 加密
            admin.setPwd(CommonUtil.MD5Encr(admin.getPwd()));
            adminRepository.save(admin);
            return HttpStatus.OK;
        }
        return null;
    }

    @Override
    public HttpStatus update(Admin admin) {
        String account = admin.getAccount();
        Admin admin1 = null;
        admin1 = findAdminByAccount(account);
        if (admin1 == null) {
            return HttpStatus.NOT_FOUND;
        }
        if (admin.getMobile() != null){
            admin1.setMobile(admin.getMobile());
        }
        if (admin.getEmail() != null) {
            admin1.setEmail(admin.getEmail());
        }
        if (admin.getPwd() != null) {
            //todo 加密
            admin1.setPwd(admin.getPwd());
        }
        if (admin.getDepartment() != null) {
            admin1.setDepartment(admin.getDepartment());
        }
//        if (admin.getAdminRoles() != null && admin.getAdminRoles().size()>0){
//            admin.getAdminRoles().addAll(admin.getAdminRoles());
//            admin1.setAdminRoles(admin.getAdminRoles());
//        }
        adminRepository.save(admin1);
        return HttpStatus.OK;
    }

    @Override
    public void delete(Admin admin) {

    }

    @Override
    public List<Admin> getAll(PageRequest pageRequest) {

        return adminRepository.findAll(pageRequest).getContent();
    }
}
