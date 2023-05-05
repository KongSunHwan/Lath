package com.example.thishouse.mapper;

import com.example.thishouse.domain.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper //Mapper.xml에 있는 것을 매핑 , "@Mapper" 어노테이션을 사용하여 해당 인터페이스가 MyBatis 매퍼 인터페이스임을 나타냄
public interface MemberMapper {

    int idCk(String user_id); // "String" 타입의 "id" 매개변수를 받고, "int" 타입의 결과를 반환
    void signupMember(Member member);
    Long loginMember(String user_id, String user_pw, String user_name);
}
