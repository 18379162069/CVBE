package com.cv.be.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by zhou_wb on 2017/5/14.
 */
@Entity
@Table(name = "tb_ad")
public class AD {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "title")
    private String title;     //广告位标题

    @Column(name = "pic_url")
    private String picUrl;    //广告位图片Url

    @Column(name = "act_url")
    private String actUrl;   //触发后跳转的url

    @Column(name = "start_date")
    private LocalDate startDate;   //开始时间

    @Column(name = "end_date")
    private LocalDate endDate;      //结束时间

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getActUrl() {
        return actUrl;
    }

    public void setActUrl(String actUrl) {
        this.actUrl = actUrl;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
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
