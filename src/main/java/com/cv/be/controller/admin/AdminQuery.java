package com.cv.be.controller.admin;

import com.cv.be.entity.Admin;
import com.cv.be.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhou_wb on 2017/5/14.
 */
@Controller
@RequestMapping("adminUser/")
public class AdminQuery {

    @Autowired
    AdminService adminService;

    /**
     * 添加管理员时检测是否存在账号
     * @param account
     * @return
     */
    @GetMapping("/{id}")
    @ResponseBody
    ResponseEntity<Admin> findAdminUserByAccount(@RequestParam String account){
        Admin admin = null;
        if (account != null && !account.equals("")){
           admin =  adminService.findAdminByAccount(account);
            if (admin != null) {
                return ResponseEntity.ok(admin);
            } else {
                return ResponseEntity.ok(admin);
            }
        } else {
            return ResponseEntity.ok(admin);
        }

    }


}
