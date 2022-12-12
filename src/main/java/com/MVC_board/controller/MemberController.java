package com.MVC_board.controller;

import com.MVC_board.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @RequestMapping("/usr/member/join")
    @ResponseBody
    public String join(String loginId, String loginPw, String name, String nickname, String email, String cellphoneNo) {
        memberService.join(loginId, loginPw, name, nickname, email, cellphoneNo);

        return "회원가입완료";
    }
}
