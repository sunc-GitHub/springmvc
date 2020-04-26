package com.jsu.js.controller;

import com.jsu.js.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @Auther: next door
 * @Date: 2020/4/15 14:30
 * @Description:
 */

@Controller()
@RequestMapping("userTest")
public class UserController {

    /*
     * @Description: 默认支持get.set请求
     */
    @RequestMapping(path = "testMethod", method = RequestMethod.GET)
    public String testMethod() {
        return "success";
    }

    /*
     *@RequestParam value指定参数的名称，required默认（true）情况下，参数必须存在
     * 400 接收参数类型不一样
     */
    @RequestMapping(path = "testParameter", method = RequestMethod.GET)
    public String testParameter(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "password", required = false) Integer password) {
        System.out.println(name + password);
        return "success";
    }

    /*
     *1. jsp的编码方式 jsp--翻译（pageEncoding）--->servlet-javac编译（unicode uft-8）--
     *    servlet.class-tomcat-response进行响应（contentType）-客户端
     * 2.
     */
    @RequestMapping(path = "testEncoding", method = RequestMethod.POST)
    public String testEncoding(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "password", required = false) Integer password) {
        String temp = null;
        try {
            //使用utf-8进行解码
            temp = URLDecoder.decode("%E5%AD%99%E8%B6%85", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(temp);
        return "success";
    }

    /**
     * @param name
     * @param password
     * @return String
     */
    @RequestMapping(path = "testPathVarible/{name}", method = {RequestMethod.POST, RequestMethod.GET})
    public String testPathVarible(
            @PathVariable("name") String name,
            @RequestParam(value = "password", required = false) Integer password) {
        return "success";
    }

    /**
     * modelAndView是拖过request请求发送过去的
     *
     * @return String
     */
    @RequestMapping(path = "testModelAndView", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView testModelAndView(User user) {
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("success", "name", user.getName());
        return modelAndView;
    }

    /**
     * 重定向不能访问web-inf下面的资源,重定向会绕过视图解析器
     *
     * @return
     */
    @RequestMapping(path = "testRedict", method = {RequestMethod.POST, RequestMethod.GET})
    public String testRedict() {
        return "redirect:/success.jsp";
    }

    /**
     * 重定向不能访问web-inf下面的资源,重定向会绕过视图解析器
     *
     * @return
     */
    @RequestMapping(path = "testRedict", method = {RequestMethod.POST, RequestMethod.GET})
    public String testForward() {
        return "forward:/success.jsp";
    }
}
