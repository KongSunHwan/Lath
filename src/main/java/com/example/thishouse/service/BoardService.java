package com.example.thishouse.service;

import com.example.thishouse.domain.Member;
import com.example.thishouse.mapper.BoardMapper;
import com.example.thishouse.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    //community(커뮤니티), community_reply(커뮤니티 댓글)

    private final BoardMapper boardMapper;

    //글작성
    //댓글작성
    //상세내용보기
    //글 삭제
    //글 수정
    //댓글 삭제
    //페이징 리스트

}
