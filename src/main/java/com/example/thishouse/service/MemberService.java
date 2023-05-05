package com.example.thishouse.service;

import com.example.thishouse.domain.Member;
import com.example.thishouse.mapper.MemberMapper;
import com.example.thishouse.repository.MemberDao;
import com.example.thishouse.repository.MemberDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 비즈니스 로직을 처리하는 클래스 , 이 클래스에는 MemberDao 인터페이스를 구현한 MemberDaoImpl 객체가 주입되어 사용
@Service //@Service 어노테이션은 Spring Framework에서 비즈니스 로직을 처리하는 서비스 클래스임을 표시하는 어노테이션
//이 어노테이션이 선언된 클래스는 Spring에서 관리되며, 이를 통해 Controller와 Repository 사이에서 비즈니스 로직을 처리할 수 있음
public class MemberService {
    static MemberDao dao;
    @Autowired
    public MemberService(MemberDaoImpl dao) {this.dao = dao;}
    public int idCk(String user_id) {
        System.out.println(user_id + "SER INPUT");
        int result = dao.idCk(user_id);
        System.out.println(result + "SER");
        return result;
    }

    public static void signupMember(Member member) {
        dao.signupMember(member);
    }

    public static Long loginMember(String user_id, String user_pw, String user_name) {
        Long result = dao.loginMember(user_id,user_pw,user_name);
        if(user_id.equals(user_id) && user_pw.equals(user_pw)) {
            return result;
        }
        return null;
    }

}
