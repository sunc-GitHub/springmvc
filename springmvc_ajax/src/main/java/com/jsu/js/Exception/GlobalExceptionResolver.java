package com.jsu.js.Exception;

import com.google.gson.Gson;
import com.jsu.js.pojo.Msg;
import com.mysql.jdbc.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * @description:
 * @author: sunc-idea
 * @time: 2020/5/11 20:07
 */
public class GlobalExceptionResolver extends SimpleMappingExceptionResolver {


    @Override
    protected ModelAndView doResolveException(HttpServletRequest request,
                                              HttpServletResponse response,
                                              Object handler, Exception ex) {

        //x-Requested-with XMLHttpRequest
        String ajaxHeader = request.getHeader("x-Requested-with");
        //判断是不是ajax请求
        if (!StringUtils.isNullOrEmpty(ajaxHeader) && "XMLHttpRequest".equals(ajaxHeader)) {
            Writer writer = null;
            try {
                //将错误信息返回给前台
                String message = ex.getMessage();

                Msg msg = new Msg(false, null, message);

                //转为json字符串
                Gson gson = new Gson();
                String jsonMsg = gson.toJson(msg);

                //将信息响应到前端
                writer = response.getWriter();
                writer.write(jsonMsg);
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

            //直接进行错误页面的跳转
            ModelAndView modelAndView = super.doResolveException(request, response, handler, ex);
            return modelAndView;
        }
        return null;
    }
}
