package com.MVC_board.service;

import com.MVC_board.repository.MemberRepository;
import com.MVC_board.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;


    public ResultData join(String loginId, String loginPw, String name, String nickname, String email, String cellphoneNo) {
        memberRepository.join(loginId, loginPw, name, nickname, email, cellphoneNo);
        return ResultData.from("S-1", loginId + "님 회원가입완료");
    }

    public String getLoginIdOfMember(String loginId) {
        loginId = memberRepository.getLoginIdOfMember(loginId);
        return loginId;
    }

    public String getLoginPwOfMember(String loginId) {
        String loginPw = memberRepository.getLoginPwOfMember(loginId);
        return loginPw;
    }

    public boolean getEmailOfMember(String email) {
        if (memberRepository.getEmailOfMember(email) >= 1) {
            return false;
        }
        return true;
    }


}
