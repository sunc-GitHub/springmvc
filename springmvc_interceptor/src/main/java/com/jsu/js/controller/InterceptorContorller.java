package com.jsu.js.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: 拦截器
 * @author: sunc-idea
 * @time: 2020/5/12 20:41
 */
@Controller
@RequestMapping("interceptor")
public class InterceptorContorller {

    @RequestMapping("page1")
    public String page1(){
        return "success";
    }

    @RequestMapping("page2")
    public String page2(){
        return "success";
    }

    @RequestMapping("page3")
    public String page3(){
        return "success";
    }
}
