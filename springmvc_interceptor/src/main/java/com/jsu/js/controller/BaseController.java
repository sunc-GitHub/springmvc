package com.jsu.js.controller;

import com.jsu.js.Exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * @description:
 * @author: sunc-idea
 * @time: 2020/5/11 16:57
 */
@Controller
public abstract class BaseController {

    @ExceptionHandler
    public String  exception(HttpServletRequest request,Exception ex){
        request.setAttribute("ex",ex);
        //根据不同错误转向不同页面(统一处理) ，即异常与view的对应关系
        if (ex instanceof MyException) {
            return "forward:/WEB-INF/jsp/error/error.jsp" ;
        } else if (ex instanceof SQLException) {
            return "forward:/WEB-INF/jsp/error/error.jsp" ;
        } else if (ex instanceof IndexOutOfBoundsException) {
            return "forward:/WEB-INF/jsp/error/error.jsp" ;
        } else {
            return "forward:/WEB-INF/jsp/error/notFound.jsp" ;
        }

    }
}
