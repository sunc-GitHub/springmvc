package com.jsu.js.controller;


import com.jsu.js.pojo.District;
import com.jsu.js.pojo.User;
import com.jsu.js.service.Imp.UserServiceImp;
import com.jsu.js.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String inputUser(Model model, ModelMap modelMap) {
        model.addAttribute("user", new User());
        HashMap<Integer, String> hobbies = new HashMap<Integer, String>();
        hobbies.put(1, "篮球");
        hobbies.put(2, "羽毛球");
        hobbies.put(3, "台球");
        hobbies.put(4, "游泳");
        model.addAttribute("user", new User());

        List contacts = new ArrayList(10);
        contacts.add("张三");
        contacts.add("李四");
        contacts.add("王五");
        contacts.add("赵六");

        /*<option value="1">北京</option>
            <option value="2">上海</option>
            <option value="3">广州</option>
            <option value="4">深圳</option>
            <option value="5">其它</option>*/
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
        return "register";
    }

}
