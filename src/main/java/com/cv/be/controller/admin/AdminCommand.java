package com.cv.be.controller.admin;

import com.cv.be.entity.Admin;
import com.cv.be.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhou_wb on 2017/5/13.
 */
@Controller
@RequestMapping("adminUser/")
public class AdminCommand {

    @Autowired
    AdminService adminService;

    @PostMapping("/{id}")
    @ResponseBody
    public ResponseEntity add(@PathVariable Integer id, @RequestBody Admin admin){
        if (admin != null)
        {
        }
        return null;
    }




}
