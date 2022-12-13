package com.MVC_board.service;

import com.MVC_board.repository.MemberRepository;
import com.MVC_board.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public String join(String loginId, String loginPw, String name, String nickname, String email, String cellphoneNo) {
        memberRepository.join(loginId, loginPw, name, nickname, email, cellphoneNo);
        return getLoginId(loginId).getLoginId();
    }

    public Member getLoginId(String loginId) {
        Member member = memberRepository.getLoginId(loginId);
        return member;
    }



}
