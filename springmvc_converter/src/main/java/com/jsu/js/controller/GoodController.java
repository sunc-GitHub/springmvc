package com.jsu.js.controller;

import com.jsu.js.pojo.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: sunc-idea
 * @Date: 2020/4/24
 *
 */

@Controller
@RequestMapping("goodController")
public class GoodController {

    @RequestMapping("saveGoods")
    public String saveGoods(Goods goods, Model model){

        model.addAttribute("goods",goods);

        return "success";
    }
}

