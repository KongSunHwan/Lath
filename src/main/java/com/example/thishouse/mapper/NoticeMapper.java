package com.example.thishouse.mapper;

import com.example.thishouse.domain.Member;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import com.example.thishouse.domain.Member;
import com.example.thishouse.domain.PageVO;
import com.example.thishouse.domain.Notice;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//interface사용시 오류 (required_bean error)
@Repository
@Mapper
@RequiredArgsConstructor
public class NoticeMapper {
    private final SqlSessionTemplate sqlSession;
    private static final String Namespace = "com.example.thishouse.mapper.NoticeMapper";

    public List<Notice> noticelist() {
        return sqlSession.selectList(Namespace+ ".notice_list");
    }

    public List<Notice> pg_list(Notice searchVO) { return sqlSession.selectList(Namespace + ".pg_list", searchVO);}

    public int pg_listCnt() { return sqlSession.selectOne(Namespace + ".pg_listCnt");}
}
