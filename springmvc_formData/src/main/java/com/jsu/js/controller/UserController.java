package com.jsu.js.controller;


import com.jsu.js.pojo.User;
import com.jsu.js.service.Imp.UserServiceImp;
import com.jsu.js.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

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

    @RequestMapping(value = "saveUser.action", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute() User user, Model model) {
        model.addAttribute("user", user);
        boolean isSave = userService.saveUser(user);
        if (isSave) {
            return "success";
        }
        return "error";
    }


    @RequestMapping(value = "inputUser.action", method = RequestMethod.GET)
    public String inputUser(Model model) {
        model.addAttribute("user", new User());
        HashMap<Integer, String> hobbys = new HashMap<Integer, String>();
        hobbys.put(1, "篮球");
        hobbys.put(2, "羽毛球");
        hobbys.put(3, "台球");
        hobbys.put(4, "游泳");
        model.addAttribute("user", new User());
        //register.jsp itmes 接收的数据类型
        //1.map value = key,显示的value
        model.addAttribute("hobbys", hobbys);
        //2.数组类型
        model.addAttribute("carrers", new String[]{"教师", "学生", "医生", "IT民工", "其它"});
        return "register";
    }

}
