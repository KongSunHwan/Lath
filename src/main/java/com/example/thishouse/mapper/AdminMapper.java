package com.example.thishouse.mapper;

import com.example.thishouse.domain.Alarm;
import com.example.thishouse.domain.Inquire;
import com.example.thishouse.domain.Member;
import com.example.thishouse.domain.community.Community;
import com.example.thishouse.domain.community.Community_reply;
import com.example.thishouse.domain.house.House_list;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface AdminMapper {
    public void insert_reply(Inquire inquire);

    public int memberList_cnt();

    public List<Member> memberAll(Member searchVO);

    public int member_search_cnt(String context);

    public List<Member> member_list_search(Member searchVO);

    public void member_delete(String user_num);

    public void board_modify_admin(String communityNum);

    public Community view_board(Community_reply community_reply);

    public List<Community_reply> view_reply(Community_reply community_reply);
    public void comment_update_admin(String replyNum);

    public void delete_board_reply(String communityNum);
    //전체 댓글 리스트 페이징
    public List<Community_reply> reply_list(Community_reply searchVO);
    //전체 댓글 개수
    public int reply_listCnt();

    //검색 댓글 개수
    public int reply_list_search_Cnt(Community_reply searchVO);

    public List<Community_reply> reply_list_search(Community_reply searchVO);

    public List<HashMap> re_list(House_list searchVO);

    public int re_list_cnt();

    public void approval_ok_house_item(String houseNum);

    public void approval_ok_house_list(String houseNum);

    public void approval_no_house_item(String houseNum);

    public void approval_no_house_list(String houseNum);

    public List<HashMap> no_re_list(House_list searchVO);

    public int no_re_list_cnt();

}
