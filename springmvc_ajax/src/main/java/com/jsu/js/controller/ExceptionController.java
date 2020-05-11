package com.jsu.js.controller;

import com.jsu.js.Exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

/**
 * @description:
 * @author: sunc-idea
 * @time: 2020/5/11 15:09
 */
@Controller
@RequestMapping("exception")
public class ExceptionController extends BaseController {

    @RequestMapping("sqlException")
    public String tosqlException() throws SQLException {
        throw new java.sql.SQLException("数据库异常");
    }

    @RequestMapping("myException")
    public String myException() throws Exception  {
        throw new MyException("自定义异常");
    }

    /**
     * 默认异常
     * @return
     * @throws Exception
     */
    @RequestMapping("defaultException")
    public String defaultException() throws Exception  {
        throw new IndexOutOfBoundsException("数组越界异常");
    }
}
