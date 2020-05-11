package com.jsu.js.Exception;


/**
 * @description:自定义异常对象
 * @author: sunc-idea
 * @time: 2020/5/11 15:40
 */
public class MyException extends Exception {
    private String message;

    public MyException(String message) {
        this.message = message;
    }

    public MyException() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
