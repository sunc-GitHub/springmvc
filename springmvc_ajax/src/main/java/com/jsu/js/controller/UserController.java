package com.jsu.js.controller;


import com.jsu.js.commons.UploadUtils;
import com.jsu.js.pojo.Msg;
import com.jsu.js.pojo.User;
import com.jsu.js.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: next door
 * @Date: 2020/4/15 14:30
 * @Description:
 */

@Controller()
@RequestMapping("userController")
public class UserController {

    @Autowired
    private UserService userService;

    //JSR303服务器校验
    //支持服务器向客户端发送各种数据
    @ResponseBody()
    //RequestMapping 参数 consumes ="application/json;charset=utf-8" 指定前台传递到后台数据
    //produces ="application/json;charset=utf-8" 后台响应的数据
    @RequestMapping(value = "saveUser.action", method = {RequestMethod.POST})
    public Msg saveUser(@Valid User user, Errors errors, Model model,
                        HttpServletRequest req, HttpServletResponse response)
            throws IOException {
        Map errorMap = new HashMap<>(10);
        //JSR303服务器校验
        if (errors.hasErrors()) {
            List<FieldError> fieldErrors = errors.getFieldErrors();
            for (FieldError e : fieldErrors) {
                String fileName = e.getField();
                String message = e.getDefaultMessage();
                errorMap.put(fileName, message);
            }
        } else {
            MultipartFile[] multipartFiles = user.getMultipartFile();
            //发布路径 D:\ideaProjec\springmvc\springmvc_upload\target\springmvc_formData
            String dir = "upload/" + user.getName();
            String targetDir = req.getServletContext().getRealPath(dir);
            //文件上传
            UploadUtils.saveDocument(multipartFiles, targetDir);
        }
        Msg msg = new Msg();
        Boolean isNotError = true;
        if (errorMap.size() > 0) {
            isNotError = false;
        } else {
            userService.saveUser(user);
        }
        msg.setFlag(isNotError);
        msg.setData(errorMap);

        return msg;
    }


    @RequestMapping(value = "testSave.action", produces = "application/json;charset=utf-8", consumes = "application/json;charset=utf-8",
            method = {RequestMethod.POST})
    @ResponseBody //支持服务器向浏览器发送各种数据,java对象以json格式返回
    public String testSave(@RequestBody User user, Model model, HttpServletResponse response,
                           HttpServletRequest req) throws IOException {
        String json = "{\"json1\":\"json1\"}";
        return user.getName();
    }

}
