package com.example.thishouse.service;

import com.example.thishouse.domain.community.Community;
import com.example.thishouse.domain.community.Community_reply;
import com.example.thishouse.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    //community(커뮤니티), community_reply(커뮤니티 댓글)

    private final BoardMapper boardMapper;

    //게시판 리스트 조회 select_board_list
    public List<Community> select_board_list() {
        return this.boardMapper.select_board_list();
    }

    //글작성 insert_board
    @Transactional
    public void insert_board(Community community) {
        this.boardMapper.insert_board(community);
    }
    //댓글작성 insert_reply
    @Transactional
    public void insert_reply(Community community) {
        this.boardMapper.insert_reply(community);
    }

    //상세내용보기 view_board/ view_reply
    List<Community> view_board(String community_num) {
        return this.boardMapper.view_board(community_num);
    }
    //view_reply
    List<Community_reply> view_reply(String community_num) {
        return this.boardMapper.view_reply(community_num);
    }
    //글 삭제 delete_board/ delete_reply_with_board
    @Transactional
    public void delete_board(String community_num){
        this.boardMapper.delete_board(community_num);
    }
    //글 수정 modify_board
    @Transactional
    public void modify_board(String community_num){
        this.boardMapper.modify_board(community_num); //쿼리 설정X
    }
    //댓글 삭제 delete_reply
    @Transactional
    public void delete_reply(String community_num){
        this.boardMapper.delete_reply(community_num); //쿼리 설정X
    }

    // List 검색 search
    // List 페이징 리스트 page_list

}
