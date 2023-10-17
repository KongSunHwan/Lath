package com.example.thishouse.controller;

import com.example.thishouse.util.PageCtrl;
import com.example.thishouse.domain.Notice;
import com.example.thishouse.service.NoticeService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;
    @RequestMapping("/notice_list")
    public String test2(@ModelAttribute("searchVO") Notice searchVO, HttpServletRequest request, Model model) {
        PageCtrl pagination  = new PageCtrl();
        pagination.setCurrentPageNo(searchVO.getPageIndex());
        pagination.setRecordCountPerPage(searchVO.getPageUnit());
        pagination.setPageSize(searchVO.getPageSize());
        searchVO.setFirstIndex(pagination.getFirstRecordIndex());
        searchVO.setRecordCountPerPage(pagination.getRecordCountPerPage());
        String search = request.getParameter("search");
        String context = request.getParameter("searchValue");

        if(context == null){
            List<Notice> pg_list = noticeService.pg_list(searchVO);
            model.addAttribute("pg_list" , pg_list);
            int totCnt = noticeService.pg_listCnt();
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
            List<Notice> pg_list = noticeService.pg_list(searchVO);
            model.addAttribute("pg_list" , pg_list);
            int totCnt = noticeService.pg_listCnt();
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
            List<Notice> pg_list = noticeService.pg_list_search(searchVO);
            int totCnt = noticeService.pg_list_searchcnt(searchVO);
            pagination.setTotalRecordCount(totCnt);
            searchVO.setEndDate(pagination.getLastPageNoOnPageList());
            searchVO.setStartDate(pagination.getFirstPageNoOnPageList());
            searchVO.setPrev(pagination.getXprev());
            searchVO.setNext(pagination.getXnext());
            model.addAttribute("pg_list" , pg_list);
            model.addAttribute("totCnt",totCnt);
            model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)searchVO.getPageUnit()));
            model.addAttribute("pagination",pagination);
        }
        return "notice/notice_list";
    }
    @RequestMapping("notice_detail")
    public String NoticeDetail(Model model, String notice_num) {
        noticeService.update_notice_hitCount(notice_num);
        model.addAttribute("Notice", noticeService.view_notice(notice_num));
        return "notice/notice_detail";
    }
    @PostMapping("notice_add")
    public String BoardAdd(Notice notice) {
        noticeService.insert_notice(notice);
        return "redirect:/notice_list";
    }
    @GetMapping("notice_edit")
    public String NoticeUpdateView(Model model, String notice_num) {
        model.addAttribute("Notice", noticeService.view_notice(notice_num));
        return "notice/notice_edit";
    }

    public String NoticeUpdate(@ModelAttribute Notice notice) {
        noticeService.update_notice(notice);
        return "redirect:/notice_list";
    }
    @RequestMapping("notice_delete")
    public String NoticeDelete(String notice_num) {
        noticeService.delete_notice(notice_num);
        return "redirect:/notice_list";
    }

}
