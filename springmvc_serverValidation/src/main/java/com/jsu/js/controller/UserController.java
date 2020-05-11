package com.jsu.js.controller;


import com.jsu.js.pojo.District;
import com.jsu.js.pojo.User;
import com.jsu.js.service.UserService;
import com.jsu.js.validator.UserValidater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    @Autowired
    private UserValidater userValidater;

    public void setData(Model model) {

        HashMap<String, String> hobbies = new HashMap<String, String>();
        hobbies.put("篮球", "篮球");
        hobbies.put("羽毛球", "羽毛球");
        hobbies.put("台球", "台球");
        hobbies.put("游泳", "游泳");

        List contacts = new ArrayList(10);
        contacts.add("张三");
        contacts.add("李四");
        contacts.add("王五");
        contacts.add("赵六");


        List houseRegister = new ArrayList(10);
        houseRegister.add(new District(1, "北京"));
        houseRegister.add(new District(2, "上海"));
        houseRegister.add(new District(3, "深圳"));
        houseRegister.add(new District(4, "其它"));

        //register.jsp items 接收的数据类型
        //1.map value = key,显示的value
        model.addAttribute("hobbies", hobbies);
        //2.数组类型
        model.addAttribute("careers", new String[]{"教师", "学生", "医生", "IT民工", "其它"});
        //3.集合类型
        model.addAttribute("contacts", contacts);
        //4.集合对象类型
        model.addAttribute("houseRegister", houseRegister);
    }


    /*
     1、编程验证
        a、创建验证器类 Validator接口
        b、实现两个方法
        c、validate方法进行验证 错误信息加入Errors对象中， key=shuxingming value=国际化资源文件中的key
        d、编写国际化文件
        f、判断errors对象里面是否有错误信息 ，有：准备数据，返回注册页面  否：进行业务方法调用
        g、register.jsp  <form:errors path="属性名"/>
                注意： public  ModelAndView saveUser(User user,Errors errors, ModelAndView mv, Model model)
        Errors对象：要放在ModelAttribute 对象后面，紧挨着

     2、jsr303验证
        a、加入jar包
        b、springmvc.xml中注册校验器
        c、修改controller，@Valid User user
        d、Bean属性上使用注解设置验证规则
     */

    //spring自带服务器验证
    @RequestMapping(value = "saveUser.action", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute() User user, Errors errors, Model model) {

        userValidater.validate(user, errors);

        //判断是否存在错误
        if (errors.hasErrors()) {
            this.setData(model);
            return "register";
        }
/*         model.addAttribute("user", user);
       boolean isSave = userService.saveUser(user);
        if (isSave) {
            return "success";
        }
        return "error";*/
        //这里为了做测试，没有进行保存
        return "success";
    }

    //JSR303服务器校验
    @RequestMapping(value = "saveUser2.action", method = RequestMethod.POST)
    public String saveUser2(@Valid User user, Errors errors, Model model) {

        if (errors.hasErrors()) {
            this.setData(model);
            return "register";
        }
       /*
         model.addAttribute("user", user);
       boolean isSave = userService.saveUser(user);
        if (isSave) {
            return "success";
        }*/
        /*return "error";*/
        //这里为了做测试，没有进行保存,保存到数据库有问题，mybatis类型转换器还没有完成
        return "success";
    }


    @RequestMapping(value = "inputUser.action", method = {RequestMethod.GET, RequestMethod.POST})
    public String inputUser(Model model) {
        model.addAttribute("user", new User());
        this.setData(model);
        return "register";
    }

}
