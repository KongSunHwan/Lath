package com.example.thishouse.mapper;

import com.example.thishouse.domain.Member;
import com.example.thishouse.domain.inquire;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//interface사용시 오류 (required_bean error)
@Repository
@Mapper
@RequiredArgsConstructor
public class MemberMapper {
    private final SqlSessionTemplate sqlSession;
    private static final String Namespace = "com.example.thishouse.mapper.MemberMapper";
    //회원가입 기능
    public void sign_up(Member member) {
        sqlSession.insert(Namespace+".sign_up",member);
    }
    //로그인 기능
    public int loginMember(Member member) {
        int result = sqlSession.selectOne(Namespace+".loginMember",member);
        return result;
    }
    //아이디 중복
    public int idCk(String user_id) {
        int result = sqlSession.selectOne(Namespace+".idCk",user_id);
        return result;
    }
    //회원 상세정보 조회
    public Member findInputMember(String user_id) {
        return sqlSession.selectOne(Namespace+".findInputMember", user_id);
    }
    //회원 정보 수정
    public void updateMember(Member member) {
        sqlSession.update(Namespace+".updateMember", member);
    }
    //회원 정보 삭제
    public void deleteMember(String user_id) {
        sqlSession.delete(Namespace+".deleteMember", user_id);
    }
    //회원 문의 내열 리스트 조회
    public List<inquire> findInputMemberInquire() {
        return sqlSession.selectList(Namespace+".findInputMemberInquire");
    }

}
