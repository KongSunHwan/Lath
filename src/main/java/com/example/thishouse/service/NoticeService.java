package com.example.thishouse.service;

import com.example.thishouse.domain.Criteria;
import com.example.thishouse.domain.DTO.NoticeDTO;
import com.example.thishouse.domain.Notice;
import com.example.thishouse.domain.PageDTO;
import com.example.thishouse.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NoticeService {

    private final NoticeMapper noticeMapper;

    public List<Notice> notice_list() {
        return this.noticeMapper.notice_list();
    }

    //공지사항 상세보기
    public Notice view_notice(String notice_num) {
        return noticeMapper.view_notice(notice_num);
    }

    //공지사항 조회수
    @Transactional
    public void update_notice_hitCount(String notice_num) {
        this.noticeMapper.update_notice_hitCount(notice_num);
    }
    //공지사항 등록
    @Transactional
    public void insert_notice(Notice notice) {
        this.noticeMapper.insert_notice(notice);
    }


    @Transactional
    public void delete_notice(String noticeNum) {
        this.noticeMapper.delete_notice(noticeNum);
    }

    public NoticeDTO.PageResponseList pageResponseList(Criteria criteria){
        Criteria cs = new Criteria(criteria.getPageNum(),criteria.getAmount() ,criteria.getType(), criteria.getKeyword());
        List<Notice> pageList = noticeMapper.findList(cs);
        int total = noticeMapper.findCount(cs);
        PageDTO pageDTO = new PageDTO(cs,total);
        List<NoticeDTO.Response> responses = NoticeDTO.Response.ListNoticeToNoticeDto(pageList);
        return new NoticeDTO.PageResponseList(responses, pageDTO);
    }
}
