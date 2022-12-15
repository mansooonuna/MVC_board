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
        if (loginId.isEmpty()) {
            return "아이디를 입력해주세요.";
        }
        if (loginPw.isEmpty()) {
            return "비밀번호를 입력해주세요.";
        }
        if (name.isEmpty()) {
            return "이름을 입력해주세요.";
        }
        if (nickname.isEmpty()) {
            return "닉네임을 입력해주세요.";
        }
        if (email.isEmpty()) {
            return "이메일을 입력해주세요.";
        }
        if (cellphoneNo.isEmpty()) {
            return "전화번호를 입력해주세요.";
        }


        if (loginId.equals(memberService.getLoginIdOfMember(loginId))) {
            return "해당 아이디(" + loginId + ")는 이미 존재하는 아이디 입니다.";
        }
        if (!memberService.getEmailOfMember(email)) {
            return "이미 사용중인 이메일 입니다.";
        }

        memberService.join(loginId, loginPw, name, nickname, email, cellphoneNo);

        return loginId + "님 회원가입 완료";
    }
}
