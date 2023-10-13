package com.example.thishouse.mapper;


import com.example.thishouse.domain.Inquire;
import com.example.thishouse.domain.Marker;
import com.example.thishouse.domain.Member;
import com.example.thishouse.domain.Report;
import com.example.thishouse.domain.community.Community;
import com.example.thishouse.domain.community.Community_reply;
import com.example.thishouse.domain.house.House_list;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface MemberMapper {
    //회원가입 기능
    public void sign_up(Member member);
    //로그인 기능
    public int loginMember(Member member);
    //아이디 중복
    public int idCk(String user_id);
    //회원 상세정보 조회
    public Member findInputMember(String user_id);
    //회원 정보 수정
    public void updateMember(Member member);
    //회원 정보 삭제
    public void deleteMember(String user_id);
    //회원 문의 내열 리스트 조회
    public List<Inquire> findInputMemberInquire(String user_id);

    //회원 게시글 내역 조회
    public List<Community> my_community(String user_id);
    //회원 신고 내역 조회
    public List<Report> findInputMemberReport(String user_id);

    public void inquire_insert(Inquire inquire);

    public void community_reply(Community_reply reply);

    public List<Community> my_board_list(String userId);

    public List<Inquire> my_inquire_one(String userId);

    public int house_cnt(String userId);

    public int contract_cnt(String userId);

    public int report_cnt(String userId);
}
