package com.cv.be.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhou_wb on 2017/5/13.
 */
@Entity
@Table(name = "tb_admin")
public class Admin implements Serializable{

    @Id
    @GeneratedValue
    private Integer id;          //管理员Id

    @Column(name = "real_name",nullable = false)
    @NotEmpty(message = "管理员正式姓名不能为空")
    private String realName;     //管理员正式姓名

    @Column(name = "department")
    private String department;   //部门

    @Column(name = "email")
    private String email;        //管理员邮箱

    @Column(name = "mobile")
    private String mobile;       //管理员手机号

    @Column(name = "pwd", nullable = false)
    private String pwd;           //管理员密码

    @Column(name = "salt")
    private String salt;          //盐

    @Column(name = "is_locked")
    private boolean isLocked;      //账号是否锁定

    @CreationTimestamp
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    @Column(name = "created_on", length = 29)
    private LocalDateTime createdOn;  //创建时间

    @UpdateTimestamp
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    @Column(name = "update_on", length = 29, updatable = false)
    private LocalDateTime updatedOn;  //更新时间

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_id")
    private List<AdminRole> adminRoles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public List<AdminRole> getAdminRoles() {
        return adminRoles;
    }

    public void setAdminRoles(List<AdminRole> adminRoles) {
        this.adminRoles = adminRoles;
    }

    public String getAccount(){
        if (this.email != null){
            return this.email;
        }

        if (this.mobile != null) {
            return this.mobile;
        }
        return null;
    }

}
