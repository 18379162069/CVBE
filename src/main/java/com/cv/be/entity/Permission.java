package com.cv.be.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Administrator on 2017/5/13.
 */
@Entity
@Table(name = "tb_permission")
public class Permission {

    @Id
    @GeneratedValue
    @Column(name = "per_id")
    private Integer permissionId;

    @Column(name = "tb_permission", nullable = false)
    private String permission;

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
