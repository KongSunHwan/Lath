package com.example.thishouse.mapper;

import com.example.thishouse.domain.community.Community;
import com.example.thishouse.domain.community.Community_reply;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import com.example.thishouse.domain.community.Community;

import java.util.List;

//interface사용시 오류 (required_bean error)
@Repository
@Mapper
@RequiredArgsConstructor
public class BoardMapper {
    private final SqlSessionTemplate sqlSession;
    private static final String Namespace = "com.example.thishouse.mapper.BoardMapper";

    //게시판 목록 조회
    public List<Community> select_board_list() {
        return sqlSession.selectList(Namespace + ".select_board_list");
    }

    //게시판 생성
    public void insert_board(Community community) {
        sqlSession.insert(Namespace+".insert_board",community);
    }

    //게시판 댓글 생성
    public void insert_reply(Community community) {
        sqlSession.insert(Namespace+".insert_reply",community);
    }

    //게시판 상세정보 조회
    public List<Community> view_board(String communityNum) {
        return sqlSession.selectList(Namespace+".view_board",communityNum);
    }
    //게시판 상세정보 댓글 조회
    public List<Community_reply> view_reply(String communityNum) {
        return sqlSession.selectList(Namespace+".view_reply",communityNum);
    }
    //게시판 삭제
    public void delete_board(String communityNum) {
        sqlSession.insert(Namespace+".delete_board",communityNum);
    }
    //게시판 수정
    public void modify_board(String communityNum) {
        sqlSession.update(Namespace+".modify_board",communityNum);
    }
    //게시판이랑 댓글 같이 삭제
    public void delete_reply(String communityNum) {
        sqlSession.insert(Namespace+".delete_reply",communityNum);
    }

}
