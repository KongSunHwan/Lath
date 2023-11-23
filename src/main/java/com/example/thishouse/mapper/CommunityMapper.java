package com.example.thishouse.mapper;

import com.example.thishouse.domain.Criteria;
import com.example.thishouse.domain.Notice;
import com.example.thishouse.domain.community.Community;
import com.example.thishouse.domain.community.CommunityDTO;
import com.example.thishouse.domain.community.Community_reply;
import com.example.thishouse.domain.community.ReplyCount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityMapper {
    //게시판 목록 페이징 추가
    public List<Community> bd_list(Community searchVO);

    public int bd_listCnt();
    //게시판 생성
    public void insert_board(Community community);

    //게시판 댓글 생성
    public void insert_reply(Community_reply cm);

    //게시판 상세정보 조회
    public Community view_board(String community_num);
    //게시판 상세정보 댓글 조회
    public List<Community_reply> view_reply(String community_num);
    //게시판 삭제
    public void delete_board(String community_num);
    //게시판 수정
    public void update_board(Community community);

    public void update_board_hitCount(String community_num);
    //게시판이랑 댓글 같이 삭제
    public void delete_reply(String community_num);

    public List<Community> bd_list_search(Community searchVO);

    public int bd_list_search_Cnt(Community searchVO);

    List<CommunityDTO> findList(Criteria criteria);

    int findCount(Criteria criteria);

    List<ReplyCount> findReplyCountbycommunityNum();

}
