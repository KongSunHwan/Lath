package com.example.thishouse.mapper;

import com.example.thishouse.domain.Inquire;
import com.example.thishouse.domain.Member;
import com.example.thishouse.domain.community.Community;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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


    public int memberList_cnt() {
        return sqlSession.selectOne(Namespace+".memberList_cnt");
    }

    public List<Member> memberAll(Member searchVO) {
        return sqlSession.selectList(Namespace + ".memberAll", searchVO);
    }

    public int member_search_cnt(String context) {
        return sqlSession.selectOne(Namespace+".member_search_cnt",context);

    }

    public List<Member> member_list_search(Member searchVO) {
        return sqlSession.selectList(Namespace+".member_list_search",searchVO);
    }

    public void member_delete(String user_num) {
        sqlSession.delete(Namespace+".member_delete",user_num);
    }

    public void board_modify_admin(String communityNum) {
        sqlSession.delete(Namespace+".board_modify_admin",communityNum);
    }
}
