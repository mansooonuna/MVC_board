package com.MVC_board.service;

import com.MVC_board.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public void join(String loginId, String loginPw, String name, String nickname, String email, String cellphoneNo) {
        memberRepository.join(loginId, loginPw, name, nickname, email, cellphoneNo);
    }




}
