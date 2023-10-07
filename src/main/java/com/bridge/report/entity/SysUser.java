package com.bridge.report.entity;

import java.io.Serializable;

public class SysUser implements Serializable {


    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;


    private int roleId;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    SysUser(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
