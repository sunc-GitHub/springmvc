package com.jsu.js.controller;

import com.jsu.js.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "saveUser.action", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("user", user);
        return "success";
    }


    @RequestMapping(value = "inputUser.action", method = RequestMethod.GET)
    public String inputUser(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

}
