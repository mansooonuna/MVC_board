package com.MVC_board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/usr/home/main")
    public String showMain() {
        return "usr/home/main";
    }

}
