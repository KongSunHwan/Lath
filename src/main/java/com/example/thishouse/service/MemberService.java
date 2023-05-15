package com.example.thishouse.service;

import com.example.thishouse.domain.Member;
import com.example.thishouse.domain.Inquire;
import com.example.thishouse.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    //테이블 Members(회원)

    private final MemberMapper memberMapper;

    //@Transactional => return없이 mapper내용 실행(void함수)
    //로그인 회원가입 기능
    @Transactional
    public void sign_up(Member member) {
        this.memberMapper.sign_up(member);
    }
    //회원 로그인 기능
    public int loginMember(Member member) {
        int result = this.memberMapper.loginMember(member);
        if(result == 1) {
            return result;
        }
        return 0;
    }
    //회원 아이디 중복체크
    public int idCk(String user_id) {
        int result = memberMapper.idCk(user_id);
        return result;
    }

    //회원 상세정보 조회
    public Member findInputMember(String user_id) {
        return memberMapper.findInputMember(user_id);
    }

    //회원 정보 수정
    public void updateMember(Member member) {
        memberMapper.updateMember(member);
    }

    //회원 정보 삭제
    public void deleteMember(String user_id) {
        memberMapper.deleteMember(user_id);
    }


    //회원 문의내역
    public List<Inquire> findInputMemberInquire() {
        return memberMapper.findInputMemberInquire();
    }

    //회원 신고내역

    //회원 관심매물 내역

    //회원이 작성한 글
    //회원 거래상황
    //회원 등록한 매물


}
