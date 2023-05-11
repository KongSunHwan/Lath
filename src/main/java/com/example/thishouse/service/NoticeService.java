package com.example.thishouse.service;

import com.example.thishouse.domain.Member;
import com.example.thishouse.domain.notice;
import com.example.thishouse.mapper.MemberMapper;
import com.example.thishouse.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NoticeService {

    private final NoticeMapper noticeMapper;
    //상세내용보기
    //페이징 리스트
    //공지사항 검색

    //어드민만 수정, 삭제 가능 / 회원은 조회만
    @Transactional
    public void notice_insert (notice notice) {
        this.noticeMapper.notice_insert(notice);
    }
}
