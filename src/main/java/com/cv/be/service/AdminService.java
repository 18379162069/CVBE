package com.cv.be.service;

import com.cv.be.entity.Admin;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * Created by zhou_wb on 2017/5/13.
 */
public interface AdminService {

    /**
     * 根据管理员Id获取管理员信息
     * @param id
     * @return
     * @version 1.0
     * @author zhou_wb
     * @date 2017年5月13日
     */
    List<Admin> findAdminById(Integer id);

    /**
     * 根据管理员账号查找管理员信息
     * @param account
     * @return
     * @version 1.0
     * @author zhou_wb
     * @date 2017年5月13日
     */
    Admin findAdminByAccount(String account);

    /**
     * 添加管理员
     * @param admin
     * @return
     * @author zhou_wb
     * @date 2017年5月14日
     */
    HttpStatus add(Admin admin);

    /**
     *更新管理员
     * @param admin
     * @return
     * @author zhou_wb
     * @date 2017年5月14日
     */
    HttpStatus update(Admin admin);

    /**
     * 删除管理员
     * @author zhou_wb
     * @date 2017年5月14日
     * @param admin
     */
    void delete(Admin admin);
}
