package com.cv.be.repository;

import com.cv.be.entity.AdminRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/5/14.
 */
public interface AdminRoleRepository extends JpaRepository<AdminRole,Integer> {

    void deleteByAdminId(Integer adminId);

    AdminRole findByAdminIdAndRoleId(Integer adminId, Integer roleId);
}
