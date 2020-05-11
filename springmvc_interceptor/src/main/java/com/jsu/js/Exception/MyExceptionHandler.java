package com.jsu.js.Exception;

import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: sunc-idea
 * @time: 2020/5/11 16:05
 */
public class MyExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
                                         Object handler, Exception arg3) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("ex", arg3);
        //根据不同错误转向不同页面(统一处理) ，即异常与view的对应关系
        if (arg3 instanceof MyException) {
            return new ModelAndView("forward:/WEB-INF/jsp/error/error.jsp", model);
        } else if (arg3 instanceof SQLException) {
            return new ModelAndView("forward:/WEB-INF/jsp/error/error.jsp", model);
        } else if (arg3 instanceof IndexOutOfBoundsException) {
            return new ModelAndView("forward:/WEB-INF/jsp/error/error.jsp", model);
        } else {
            return new ModelAndView("forward:/WEB-INF/jsp/error/notFound.jsp", model);
        }
    }
}
