package Prj_MVC_board.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @RequestMapping("usr/home/main")
    @ResponseBody
    public String showMain() {
        return "안녕하세요.";
    }

    @RequestMapping("usr/home/main1")
    @ResponseBody
    public String showMain1() {
        return "드디어 성공..";
    }


}
