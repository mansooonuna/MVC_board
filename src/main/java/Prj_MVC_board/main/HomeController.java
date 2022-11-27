package Prj_MVC_board.main;

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

}
