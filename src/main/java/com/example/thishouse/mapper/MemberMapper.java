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
}
