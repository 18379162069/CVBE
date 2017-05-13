package com.cv.be.repository;

import com.cv.be.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/5/13.
 */
public interface AdminRepository extends JpaRepository<Admin,Integer> {
    /**
     * 根据管理员id查询管理员
     * @param id
     * @return
     * @author zhou_wb
     * @version 1.0
     * @date 2017年5月13日
     */
    List<Admin> findById(Integer id);

    /**
     * 根据email获取管路员信息
     * @param email
     * @return
     * @author zhou_wb
     * @version 1.0
     * @date 2017年5月13日
     */
    Admin findByEmail(String email);

    /**
     * 根据管理员手机号获取管理员信息
     * @param mobile
     * @return
     */
    Admin findByMobile(String mobile);
}
