package com.jsu.js.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author: sunc-idea
 * @Date: 2020/4/26
 */

@Controller
@RequestMapping("il8n")
public class Il8nController {

    @RequestMapping("sessionLocaleResover")
    public String test(HttpSession session, @RequestParam("locale") String locale) {
        if ("zn_CN".equals(locale)) {
            session.setAttribute("", "");
        } else if ("en_US".equals(locale)) {
            session.setAttribute("", "");
        } else {
            session.setAttribute("", "");
        }
        return "success";
    }
}
