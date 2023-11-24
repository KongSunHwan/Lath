package com.example.thishouse.mapper;

import com.example.thishouse.domain.Alarm;
import com.example.thishouse.domain.Inquire;
import com.example.thishouse.domain.Member;
import com.example.thishouse.domain.Report;
import com.example.thishouse.domain.community.Community;
import com.example.thishouse.domain.community.Community_reply;
import com.example.thishouse.domain.house.House_list;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface AdminMapper {
    void insert_reply(Inquire inquire);

    int memberList_cnt();

    List<Member> memberAll(Member searchVO);

    int member_search_cnt(String context);

    List<Member> member_list_search(Member searchVO);

    void member_delete(String user_num);

    Community view_board(Community_reply community_reply);

    List<Community_reply> view_reply(Community_reply community_reply);
    public void comment_update_admin(String replyNum);

    void delete_board_reply(String communityNum);
    //전체 댓글 리스트 페이징
    List<Community_reply> reply_list(Community_reply searchVO);
    //전체 댓글 개수
    int reply_listCnt();

    //검색 댓글 개수
    int reply_list_search_Cnt(Community_reply searchVO);

    List<Community_reply> reply_list_search(Community_reply searchVO);

    List<HashMap> re_list(House_list searchVO);

    int re_list_cnt();

    void approval_ok_house_item(String houseNum);

    void approval_ok_house_list(String houseNum);

    void approval_no_house_item(String houseNum);

    void approval_no_house_list(String houseNum);

    List<HashMap> no_re_list(House_list searchVO);

    int no_re_list_cnt();

    String get_community_num(String replyNum);

    Member user_info(String userNum);

    List<HashMap> user_house(String userNum);

    List<Community> user_community(String userNum);

    List<Report> user_report(String userNum);

    List<Community_reply> user_reply(String userNum);

    List<HashMap> user_contract(String userNum);
}
