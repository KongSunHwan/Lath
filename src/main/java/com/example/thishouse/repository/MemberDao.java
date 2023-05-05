package com.example.thishouse.repository;

import com.example.thishouse.domain.Member;

// 이 인터페이스는 데이터베이스와의 상호작용을 위한 메서드들을 정의
// "MemberDaolmpl" 클래스에서 이 인터페이스를 구현함으로써 실제로 데이터베이스와의 상호작용이 이루어지며,
// 이를 통해 "MemberService" 클래스에서 비즈니스 로직을 구현
public interface MemberDao {
    int idCk(String user_id);
    void signupMember(Member member);
    Long loginMember(String user_id, String user_pw, String user_name);
}
