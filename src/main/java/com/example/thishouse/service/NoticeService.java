package com.example.thishouse.service;

import com.example.thishouse.domain.Member;
import com.example.thishouse.domain.Notice;
import com.example.thishouse.mapper.MemberMapper;
import com.example.thishouse.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NoticeService {

    private final NoticeMapper noticeMapper;

    public List<Notice> noticeList() {
        return this.noticeMapper.noticelist();
    }

    public List<Notice> pg_list(Notice searchVO) {
        return this.noticeMapper.pg_list(searchVO);
    }

    public int pg_listCnt() {
        return this.noticeMapper.pg_listCnt();
    }
    //상세내용보기
    //페이징 리스트
    //공지사항 검색
}
