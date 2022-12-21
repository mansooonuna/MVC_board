package com.MVC_board.controller;

import com.MVC_board.service.MemberService;
import com.MVC_board.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @RequestMapping("/usr/member/join")
    @ResponseBody
    public ResultData join(String loginId, String loginPw, String name, String nickname, String email, String cellphoneNo) {
        if (loginId.isEmpty()) {
            return ResultData.from("F-1", "아이디를 입력해주세요.");
        }
        if (loginPw.isEmpty()) {
            return ResultData.from("F-2", "비밀번호를 입력해주세요.");
        }
        if (name.isEmpty()) {
            return ResultData.from("F-3", "이름을 입력해주세요.");
        }

        if (nickname.isEmpty()) {
            return ResultData.from("F-4", "닉네임(별칭)을 입력해주세요.");
        }

        if (email.isEmpty()) {
            return ResultData.from("F-5", "이메일을 입력해주세요.");
        }

        if (cellphoneNo.isEmpty()) {
            return ResultData.from("F-6", "핸드폰 번호를 입력해주세요.");
        }

        if (loginId.equals(memberService.getLoginIdOfMember(loginId))) {
            return ResultData.from("F-7", "해당 아이디(" + loginId + ")는 이미 존재하는 아이디 입니다.");
        }
        if (!memberService.getEmailOfMember(email)) {
            return ResultData.from("F-8", "이미 사용중인 이메일 입니다.");
        }


        return memberService.join(loginId, loginPw, name, nickname, email, cellphoneNo);
    }

    @RequestMapping("/usr/member/login")
    @ResponseBody
    public ResultData login(HttpSession httpSession, String loginId, String loginPw) {

        boolean isLoggedIn = false;

        if (httpSession.getAttribute("loggedInMemberId") != null) {
            isLoggedIn = true;
        }

        if (isLoggedIn) {
            return ResultData.from("F-9", "이미 로그인 되었습니다.");
        }

        if (loginId.isEmpty()) {
            return ResultData.from("F-1", "아이디를 입력해주세요.");
        }
        if (loginPw.isEmpty()) {
            return ResultData.from("F-2", "비밀번호를 입력해주세요.");
        }

        if (!loginId.equals(memberService.getLoginIdOfMember(loginId))) {
            return ResultData.from("F-7", "존재하지 않는 아이디 입니다.");
        }

        if (!loginPw.equals(memberService.getLoginPwOfMember(loginPw))) {
            return ResultData.from("F-7", "비밀번호가 일치하지 않습니다.");
        }

        httpSession.setAttribute("loggedInMemberId", loginId);

        return ResultData.from("S-1", loginId + "님 반갑습니다.");
    }

    @RequestMapping("/usr/member/logout")
    @ResponseBody
    public ResultData login(HttpSession httpSession, String loginId) {
        boolean isLoggedIn = false;
        httpSession.removeAttribute("loggedInMemberId");
        return ResultData.from("S-1", "로그아웃!");
    }
}
