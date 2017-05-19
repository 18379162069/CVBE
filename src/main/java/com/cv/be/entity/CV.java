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
@Table(name = "tb_cv")
public class CV {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "admin_name")
    private String adminName;                     //管理员姓名

    @Column(name = "user_id")
    private Integer userId;                     //管理员姓名

    @Column(name = "basic_info",length = 5000)
    private String basicInfo;                  //基本信息

    @Column(name = "cv_iteams", length = 5000)
    private String cvItrams;                    //简历信息

    @Column(name = "add_quiz", length = 5000)
    private String addQuiz;                     //附加信息
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(String basicInfo) {
        this.basicInfo = basicInfo;
    }

    public String getCvItrams() {
        return cvItrams;
    }

    public void setCvItrams(String cvItrams) {
        this.cvItrams = cvItrams;
    }

    public String getAddQuiz() {
        return addQuiz;
    }

    public void setAddQuiz(String addQuiz) {
        this.addQuiz = addQuiz;
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

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
}
