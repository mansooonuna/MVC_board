package com.MVC_board.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberRepository {

    @Insert("""
            INSERT INTO member (regDate, updateDate, loginId, loginPw, name, nickname, email, cellphoneNo)
            VALUES (NOW(), NOW(), #{loginId}, #{loginPw}, #{name}, #{nickname}, #{email}, #{cellphoneNo})
            """)
    public void join(@Param("loginId") String loginId, @Param("loginPw") String loginPw, @Param("name") String name,
                       @Param("nickname") String nickname, @Param("email") String email, @Param("cellphoneNo") String cellphoneNo);


    @Select("""
            SELECT loginId FROM member
            WHERE loginId = #{loginId}
            """)
    public String getLoginIdOfMember(@Param("loginId") String loginId);
}
