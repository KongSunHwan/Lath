package com.example.thishouse.mapper;

import com.example.thishouse.domain.Member;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
//interface사용시 오류 (required_bean error)
@Repository
@Mapper
@RequiredArgsConstructor
public class MemberMapper {
    private final SqlSessionTemplate sqlSession;
    private static final String Namespace = "com.example.thishouse.mapper.MemberMapper";
    public void sign_up(Member member) {
        sqlSession.insert(Namespace+".sign_up",member);
    }

    public int loginMember(Member member) {
        int result = sqlSession.selectOne(Namespace+".loginMember",member);
        return result;
    }

    public int idCk(String user_id) {
        int result = sqlSession.selectOne(Namespace+".idCk",user_id);
        return result;
    }


    public void modify_user(String userId) {

    }
}
