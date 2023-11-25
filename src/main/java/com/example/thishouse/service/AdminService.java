package com.example.thishouse.service;

import com.example.thishouse.domain.Inquire;
import com.example.thishouse.domain.Member;
import com.example.thishouse.domain.Report;
import com.example.thishouse.domain.community.Community;
import com.example.thishouse.domain.community.Community_reply;
import com.example.thishouse.domain.house.House_list;
import com.example.thishouse.mapper.AdminMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdminService {

    private final AdminMapper adminMapper;
    @Transactional
    public void insert_reply(Inquire inquire) {
        this.adminMapper.insert_reply(inquire);
    }
    //문의사항 답변

    public int memberList_cnt() {
        return adminMapper.memberList_cnt();
    }

    public List<Member> memberAll(Member searchVO) {
        return this.adminMapper.memberAll(searchVO);
    }

    public int member_search_cnt(String context) {
        return this.adminMapper.member_search_cnt(context);
    }

    public List<Member> member_list_search(Member searchVO) {
        return this.adminMapper.member_list_search(searchVO);
    }

    @Transactional
    public void member_delete(String userNum) {
        this.adminMapper.member_delete(userNum);
    }

    @Transactional
    public void comment_update_admin(String replyNum) {
        this.adminMapper.comment_update_admin(replyNum);
    }

    @Transactional
    public void delete_board_reply(String communityNum) {
        this.adminMapper.delete_board_reply(communityNum);
    }

    //댓글 리스트 페이징
    public List<Community_reply> reply_list(Community_reply searchVO) {
        return this.adminMapper.reply_list(searchVO);
    }
    //댓글 개수
    public int reply_listCnt() {
        return adminMapper.reply_listCnt();
    }

    //검색 댓글 개수
    public int reply_list_search_Cnt(Community_reply searchVO) {
        return this.adminMapper.reply_list_search_Cnt(searchVO);
    }

    //검색 댓글 리스트
    public List<Community_reply> reply_list_search(Community_reply searchVO) {
        return this.adminMapper.reply_list_search(searchVO);
    }

    public List<HashMap> re_list(House_list searchVO) {
        return this.adminMapper.re_list(searchVO);
    }

    public int re_list_cnt() {
        return this.adminMapper.re_list_cnt();
    }

    @Transactional
    public void approval_ok_house_item(String houseNum) {
        this.adminMapper.approval_ok_house_item(houseNum);
    }

    @Transactional
    public void approval_ok_house_list(String houseNum) {
        this.adminMapper.approval_ok_house_list(houseNum);
    }
    @Transactional
    public void approval_no_house_item(String houseNum) {
        this.adminMapper.approval_no_house_item(houseNum);
    }
    @Transactional
    public void approval_no_house_list(String houseNum) {
        this.adminMapper.approval_no_house_list(houseNum);
    }

    public List<HashMap> no_re_list(House_list searchVO) {
        return this.adminMapper.no_re_list(searchVO);
    }

    public String get_community_num(String replyNum) {
        return this.adminMapper.get_community_num(replyNum);
    }

    public int no_re_list_cnt() {
        return this.adminMapper.no_re_list_cnt();
    }

    public Member user_info(String userNum) {
            return this.adminMapper.user_info(userNum);
    }

    public List<HashMap> user_house(String userNum) {
        return this.adminMapper.user_house(userNum);
    }

    public List<Community> user_community(String userNum) {
        return this.adminMapper.user_community(userNum);

    }

    public List<Report> user_report(String userNum) {
        return this.adminMapper.user_report(userNum);
    }

    public List<Community_reply> user_reply(String userNum) {
        return this.adminMapper.user_reply(userNum);

    }

    public List<HashMap> user_contract(String userNum) {
        return this.adminMapper.user_contract(userNum);

    }
    @Transactional
    public void pw_change(String userNum) {
        this.adminMapper.pw_change(userNum);
    }
}
