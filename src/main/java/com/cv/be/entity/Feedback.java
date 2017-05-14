package com.cv.be.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Created by zhou_wb on 2017/5/14.
 */
@Entity
@Table(name = "tb_feedback")
public class Feedback {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "user_email")
    private String userEmail;     //用户邮箱

    @Column(name = "user_mobile")
    private String userMobile;   //用户手机

    @Column(name = "user_name")
    private String userName;     //用户姓名

    @Column(name = "content")
    private String content;     //用户内容

    @Column(name = "satus")
    private String status;     //反馈状态表

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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
