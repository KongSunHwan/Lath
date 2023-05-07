package com.example.thishouse.service;

import com.example.thishouse.domain.Member;
import com.example.thishouse.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberMapper memberMapper;

    //@Transactional => return없이 mapper내용 실행(void함수)
    @Transactional
    public void sign_up(Member member) {
        this.memberMapper.sign_up(member);
    }

    public int loginMember(Member member) {
        int result = this.memberMapper.loginMember(member);
        if(result == 1) {
            return result;
        }
        return 0;
    }

    public int idCk(String user_id) {
        int result = memberMapper.idCk(user_id);
        return result;
    }
}
