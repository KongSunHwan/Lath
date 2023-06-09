package com.example.thishouse.controller;

import com.example.thishouse.domain.Notice;
import com.example.thishouse.domain.community.Community;
import com.example.thishouse.domain.community.Community_reply;
import com.example.thishouse.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        String search = request.getParameter("searchName");
        String context = request.getParameter("searchValue");
        System.out.println(search + " " + context);

        if(context == null){
            List<Community> bd_list = boardService.bd_list(searchVO);
            model.addAttribute("bd_list" , bd_list);
            int totCnt = boardService.bd_listCnt();
            model.addAttribute("totCnt",totCnt);
            System.out.println("전체 게시글 수 : " + totCnt);

            pagination.setTotalRecordCount(totCnt);

            searchVO.setEndDate(pagination.getLastPageNoOnPageList());
            searchVO.setStartDate(pagination.getFirstPageNoOnPageList());
            searchVO.setPrev(pagination.getXprev());
            searchVO.setNext(pagination.getXnext());
            model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)searchVO.getPageUnit()));
            model.addAttribute("pagination",pagination);
        }
        else if(context != null && context == ""){
            List<Community> bd_list = boardService.bd_list(searchVO);
            model.addAttribute("bd_list" , bd_list);
            int totCnt = boardService.bd_listCnt();
            model.addAttribute("totCnt",totCnt);
            System.out.println("전체 게시글 수 : " + totCnt);

            pagination.setTotalRecordCount(totCnt);

            searchVO.setEndDate(pagination.getLastPageNoOnPageList());
            searchVO.setStartDate(pagination.getFirstPageNoOnPageList());
            searchVO.setPrev(pagination.getXprev());
            searchVO.setNext(pagination.getXnext());
            model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)searchVO.getPageUnit()));
            model.addAttribute("pagination",pagination);
        }
        else{
            System.out.println("제대로 검색실행");
            searchVO.setSearch_name(search);
            searchVO.setSearch_content(context);
            List<Community> pg_list = boardService.bd_list_search(searchVO);
            int totCnt = boardService.bd_list_search_Cnt(searchVO);

            System.out.println("전체 게시글 수 : " + totCnt);

            pagination.setTotalRecordCount(totCnt);

            searchVO.setEndDate(pagination.getLastPageNoOnPageList());
            searchVO.setStartDate(pagination.getFirstPageNoOnPageList());
            searchVO.setPrev(pagination.getXprev());
            searchVO.setNext(pagination.getXnext());
            model.addAttribute("bd_list" , pg_list);
            model.addAttribute("totCnt",totCnt);
            model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)searchVO.getPageUnit()));
            model.addAttribute("pagination",pagination);
        }
        return "board/board_list";
    }


    //게시판 상세 조회
    @RequestMapping("board_detail")
    public String BoardDetail(Model model, String community_num) {
        System.out.println("이것은 " + community_num);
        boardService.update_board_hitCount(community_num);
        model.addAttribute("Board", boardService.view_board(community_num));

        //댓글
        model.addAttribute("reply", boardService.view_reply(community_num));
        return "board/board_detail";
    }

    @RequestMapping("reply_add")
    public String ReplyAdd(HttpServletRequest request){
        String x = request.getParameter("reply_text");
        String id = request.getParameter("user_id");
        String num = request.getParameter("community_num");
        Community_reply cr = new Community_reply();
        cr.setCommunity_num(Integer.parseInt(num));
        cr.setReply_contents(x);
        cr.setUser_id(id);

        if(x.equals("")){
            System.out.println("빈칸이라서 댓글 추가 x");
        }
        else{
            boardService.insert_reply(cr);
        }
        System.out.println("텍스트 : "+ x);
        System.out.println("작성자 : "+ id);
        System.out.println("커뮤니티번호 : "+ num);

        return "redirect:/board_detail?community_num=" + num;
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
