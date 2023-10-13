package com.example.thishouse.controller;

import com.example.thishouse.util.PageCtrl;
import com.example.thishouse.domain.community.Community;
import com.example.thishouse.domain.community.Community_reply;
import com.example.thishouse.service.CommunityService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
public class CommunityController {

    private final CommunityService communityService;

    @RequestMapping("community")
    public String community(@ModelAttribute("searchVO") Community searchVO, HttpServletRequest request, Model model) {
        PageCtrl pagination  = new PageCtrl();
        pagination.setCurrentPageNo(searchVO.getPageIndex());
        pagination.setRecordCountPerPage(searchVO.getPageUnit());
        pagination.setPageSize(searchVO.getPageSize());
        searchVO.setFirstIndex(pagination.getFirstRecordIndex());
        searchVO.setRecordCountPerPage(pagination.getRecordCountPerPage());
        String search = request.getParameter("searchName");
        String context = request.getParameter("searchValue");
        if(context == null){
            List<Community> bd_list = communityService.bd_list(searchVO);
            model.addAttribute("bd_list" , bd_list);
            int totCnt = communityService.bd_listCnt();
            model.addAttribute("totCnt",totCnt);
            pagination.setTotalRecordCount(totCnt);
            searchVO.setEndDate(pagination.getLastPageNoOnPageList());
            searchVO.setStartDate(pagination.getFirstPageNoOnPageList());
            searchVO.setPrev(pagination.getXprev());
            searchVO.setNext(pagination.getXnext());
            model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)searchVO.getPageUnit()));
            model.addAttribute("pagination",pagination);
        }
        else if(context != null && context == ""){
            List<Community> bd_list = communityService.bd_list(searchVO);
            model.addAttribute("bd_list" , bd_list);
            int totCnt = communityService.bd_listCnt();
            model.addAttribute("totCnt",totCnt);
            pagination.setTotalRecordCount(totCnt);
            searchVO.setEndDate(pagination.getLastPageNoOnPageList());
            searchVO.setStartDate(pagination.getFirstPageNoOnPageList());
            searchVO.setPrev(pagination.getXprev());
            searchVO.setNext(pagination.getXnext());
            model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)searchVO.getPageUnit()));
            model.addAttribute("pagination",pagination);
        }
        else{
            searchVO.setSearch_name(search);
            searchVO.setSearch_content(context);
            List<Community> pg_list = communityService.bd_list_search(searchVO);
            int totCnt = communityService.bd_list_search_Cnt(searchVO);
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
        return "main/community";
    }


    //게시판 상세 조회
    @RequestMapping("board_detail")
    public String board_detail(Model model, String community_num) {
        communityService.update_board_hitCount(community_num);
        model.addAttribute("Board", communityService.view_board(community_num));
        model.addAttribute("reply", communityService.view_reply(community_num));
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
        }
        else{
            communityService.insert_reply(cr);
        }
        return "redirect:/board_detail?community_num=" + num;
    }

    //게시판 등록 View
    @GetMapping("board_add")
    public String board_add(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session == null){
            return "redirect:/login";
        }
        return "board/board_add";
    }

    //게시판 등록 기능
    @PostMapping("board_add")
    public String board_add(Community community) {
        communityService.insert_board(community);
        return "redirect:/board_list";
    }
    //게시판 수정 View
    @GetMapping("board_edit")
    public String board_edit(Model model, String community_num) {
        model.addAttribute("Board", communityService.view_board(community_num));
        return "board/board_edit";
    }

    //게시판 수정 기능
    @PostMapping("board_edit")
    public String board_edit(@ModelAttribute Community community) {
        communityService.update_board(community);
        return "redirect:/board_list";
    }

    @RequestMapping("board_delete")
    public String board_delete(String community_num) {
        communityService.delete_board(community_num);
        return "redirect:/board_list";
    }

}
