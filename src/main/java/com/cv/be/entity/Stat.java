package com.cv.be.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by zhou_wb on 2017/5/14.
 */
@Entity
@Table(name = "tb_stat")
public class Stat {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "type")
    private String type;   //统计类型

    @Column(name = "stat_time")
    private String statTime;   //统计的时间

    @Column(name = "count")
    private String count;     //统计数据

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatTime() {
        return statTime;
    }

    public void setStatTime(String statTime) {
        this.statTime = statTime;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
