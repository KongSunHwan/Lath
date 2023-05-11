package com.example.thishouse.mapper;

import com.example.thishouse.domain.Member;
import com.example.thishouse.domain.notice;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

//interface사용시 오류 (required_bean error)
@Repository
@Mapper
@RequiredArgsConstructor
public class NoticeMapper {
    private final SqlSessionTemplate sqlSession;
    private static final String Namespace = "com.example.thishouse.mapper.NoticeMapper";

    public void notice_insert(notice notice)  { sqlSession.insert(Namespace+".notice_insert",notice);   }


}
