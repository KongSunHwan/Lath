package com.example.thishouse.controller;

import com.example.thishouse.domain.Notice;
import com.example.thishouse.domain.community.Community;
import com.example.thishouse.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TestKongController {
    private final BoardService boardService;

    //게시판 목록
//    @RequestMapping("board_list")
//    public String BoardList(Model model) {
//        List<Community> list = boardService.select_board_list();
//        model.addAttribute("list", list);
//        return "board/board_list";
//    }

    @RequestMapping("board_list")
    public String BoardList(@ModelAttribute("searchVO") Community searchVO, HttpServletRequest request, Model model) {
        PageCtrl pagination  = new PageCtrl();
        pagination.setCurrentPageNo(searchVO.getPageIndex());
        pagination.setRecordCountPerPage(searchVO.getPageUnit());
        pagination.setPageSize(searchVO.getPageSize());

        searchVO.setFirstIndex(pagination.getFirstRecordIndex());
        searchVO.setRecordCountPerPage(pagination.getRecordCountPerPage());
        System.out.println("펄스트인덱스 : " + searchVO.getFirstIndex());

        List<Community> bd_list = boardService.bd_list(searchVO);
        int totCnt = boardService.bd_listCnt();

        pagination.setTotalRecordCount(totCnt);

        searchVO.setEndDate(pagination.getLastPageNoOnPageList());
        searchVO.setStartDate(pagination.getFirstPageNoOnPageList());
        searchVO.setPrev(pagination.getXprev());
        searchVO.setNext(pagination.getXnext());

        model.addAttribute("bd_list" , bd_list);
        model.addAttribute("totCnt",totCnt);
        model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)searchVO.getPageUnit()));
        model.addAttribute("pagination",pagination);
        return "board/board_list";
    }


    //게시판 상세 조회
    @RequestMapping("board_detail")
    public String BoardDetail(Model model, String community_num) {
        System.out.println(community_num);
        boardService.update_board_hitCount(community_num);
        model.addAttribute("Board", boardService.view_board(community_num));
        return "board/board_detail";
    }

    //게시판 등록 View
    @GetMapping("board_add")
    public String BoardAddView() {
        return "board/board_add";
    }

    //게시판 등록 기능
    @PostMapping("board_add")
    public String BoardAdd(Community community) {
        boardService.insert_board(community);
        System.out.println(community);
        return "redirect:/board_list";
    }
    //게시판 수정 View
    @GetMapping("board_edit")
    public String BoardUpdateView(Model model, String community_num) {
        model.addAttribute("Board", boardService.view_board(community_num));
        return "board/board_edit";
    }

    //게시판 수정 기능
    @PostMapping("board_edit")
    public String BoardUpdate(@ModelAttribute Community community) {
        boardService.update_board(community);
        return "redirect:/board_list";
    }

    @RequestMapping("board_delete")
    public String BoardDelete(String community_num) {
        boardService.delete_board(community_num);
        return "redirect:/board_list";
    }

    }
