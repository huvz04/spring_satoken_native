package com.bridge.report.entity;

import java.io.Serializable;

public class SysRole implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 数据范围
     */
    private int dateRange;

    /**
     * 权限值
     */
    private String value;

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

    public int getDateRange() {
        return dateRange;
    }

    public void setDateRange(int dateRange) {
        this.dateRange = dateRange;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
