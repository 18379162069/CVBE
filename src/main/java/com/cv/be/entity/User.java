package com.cv.be.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by zhou_wb on 2017/5/14.
 */
@Entity
@Table(name = "tb_name")
public class User implements Serializable{

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "pwd")
    private String pwd;        //用户密码

    @Column(name = "real_name")
    private String realName;   //真实姓名

    @Column(name = "email")
    private String email;      //用户邮箱

    @Column(name = "mobile")
    private String mobile;     //用户手机

    @Column(name = "islocked")
    private boolean isLocked;  //用户是否锁定

    @Column(name = "source")
    private String source;     //用户来源

    @CreationTimestamp
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    @Column(name = "created_on", length = 29)
    private LocalDateTime createdOn;  //创建时间

    @UpdateTimestamp
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    @Column(name = "update_on", length = 29, updatable = false)
    private LocalDateTime updatedOn;  //更新时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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

    public boolean isLocked() {
        return isLocked;
    }

    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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
}
