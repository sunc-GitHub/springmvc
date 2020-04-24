package com.jsu.js.pojo;

/**
 * @author: sunc-idea
 * @Date: 2020/4/24
 * 地区实体类
 */
public class District {
    private int id;
    //名称
    private String name;

    public District() {
    }

    public District(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
