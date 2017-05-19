package com.cv.be.service;

import com.cv.be.entity.Admin;
import com.cv.be.entity.AdminRole;

/**
 * Created by zhou_wb on 2017/5/14.
 */
public interface AdminRoleService {

    /**
     * 根据管理员ID删除所有属于他的角色
     * @param adminId
     * @author zhou_wb
     * @date 2017年5月14日
     */
     void  deleteByAdminId(Integer adminId);

    /**
     * 添加管理员权限
     */
    AdminRole add(AdminRole adminRole);



}
