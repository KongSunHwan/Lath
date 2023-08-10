package com.example.thishouse.service;

import com.example.thishouse.domain.Inquire;
import com.example.thishouse.domain.Member;
import com.example.thishouse.domain.community.Community;
import com.example.thishouse.domain.community.Community_reply;
import com.example.thishouse.mapper.AdminMapper;
import com.example.thishouse.mapper.MemberMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdminService {
    private final AdminMapper adminMapper;
    //table 전체
    //공지사항 작성
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
    public void board_modify_page(String communityNum) {
        this.adminMapper.board_modify_admin(communityNum);
    }
}
