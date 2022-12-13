package com.MVC_board.service;

import com.MVC_board.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;


    public String join(String loginId, String loginPw, String name, String nickname, String email, String cellphoneNo) {
        memberRepository.join(loginId, loginPw, name, nickname, email, cellphoneNo);
        return getLoginIdOfMember(loginId);
    }

    public String getLoginIdOfMember(String loginId) {
        loginId = memberRepository.getLoginIdOfMember(loginId);
        return loginId;
    }


}
