package com.cv.be.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by zhou_wb on 2017/5/14.
 */
@Entity
@Table(name = "tb_log")
public class Log implements Serializable{

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "platfromn")
    private String platfrom;                 //记录的平台

    @Column(name = "opt_uid")
    private String optUid;                   //操作人Id

    @Column(name = "opt_name")
    private String optName;                   //操作人名称

    @Column(name = "opt_type")
    private String optType;                   //操作类型

    @Column(name = "opt_desc")
    private String optDesc;                   //操作描述


    @CreationTimestamp
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    @Column(name = "created_on", length = 29)
    private LocalDateTime createdOn;  //创建时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlatfrom() {
        return platfrom;
    }

    public void setPlatfrom(String platfrom) {
        this.platfrom = platfrom;
    }

    public String getOptUid() {
        return optUid;
    }

    public void setOptUid(String optUid) {
        this.optUid = optUid;
    }

    public String getOptName() {
        return optName;
    }

    public void setOptName(String optName) {
        this.optName = optName;
    }

    public String getOptType() {
        return optType;
    }

    public void setOptType(String optType) {
        this.optType = optType;
    }

    public String getOptDesc() {
        return optDesc;
    }

    public void setOptDesc(String optDesc) {
        this.optDesc = optDesc;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
}
