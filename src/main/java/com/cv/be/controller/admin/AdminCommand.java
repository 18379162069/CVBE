package com.cv.be.controller.admin;

import com.cv.be.entity.Admin;
import com.cv.be.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhou_wb on 2017/5/13.
 */
@Controller
@RequestMapping("adminUser/")
public class AdminCommand {

    @Autowired
    AdminService adminService;

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<HttpStatus> add(@RequestParam String adminName, @RequestBody Admin admin){
        HttpStatus httpStatus = null;
        if (admin != null)
        {
            httpStatus = adminService.add(admin);
        }
        return ResponseEntity.ok(httpStatus);
    }

    @PutMapping("{adminName}")
    @ResponseBody
    public ResponseEntity<HttpStatus> update(@PathVariable String adminName, @RequestBody Admin admin){
        HttpStatus httpStatus = null;
        if (admin != null) {
            httpStatus = adminService.update(admin);
        }
        return ResponseEntity.ok(httpStatus);
    }





}
