package com.example.thishouse.mapper;

import com.example.thishouse.domain.Inquire;
import com.example.thishouse.domain.community.Community;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

//interface사용시 오류 (required_bean error)
@Repository
@Mapper
@RequiredArgsConstructor
public class AdminMapper {
    private final SqlSessionTemplate sqlSession;
    private static final String Namespace = "com.example.thishouse.mapper.AdminMapper";

//문의사항 답변
    public void insert_reply(Inquire inquire) {
        sqlSession.update(Namespace+".insert_reply",inquire);
    }
}
