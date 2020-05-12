package com.jsu.js.pojo;

import java.util.Map;

/**
 * @description:
 * @author: sunc-idea
 * @time: 2020/5/4 22:33
 */
public class Msg {

    private Boolean flag;
    private Map data;
    private String message;

    public Msg(Boolean flag, Map data, String message) {
        this.flag = flag;
        this.data = data;
        this.message = message;
    }

    public Msg() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }
}
