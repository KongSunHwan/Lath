package com.example.thishouse.controller;
import com.example.thishouse.domain.PageVO;
import com.example.thishouse.domain.Notice;
import com.example.thishouse.service.NoticeService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class JeongCtrl {

    private final NoticeService noticeService;

    @RequestMapping("/notice_list1")
    public String test(Model model){
        List<Notice> noticeList = noticeService.noticeList();
        model.addAttribute("noticeList" , noticeList);
        return "notice/notice_list";
    }

    //페이징 처리
    @RequestMapping("/notice_list2")
    public String test2(@ModelAttribute("searchVO") Notice searchVO, HttpServletRequest request, Model model) {
        PageCtrl pagination  = new PageCtrl();
        pagination.setCurrentPageNo(searchVO.getPageIndex());
        pagination.setRecordCountPerPage(searchVO.getPageUnit());
        pagination.setPageSize(searchVO.getPageSize());

        searchVO.setFirstIndex(pagination.getFirstRecordIndex());
        searchVO.setRecordCountPerPage(pagination.getRecordCountPerPage());
        System.out.println("펄스트인덱스 : " + searchVO.getFirstIndex());


        List<Notice> pg_list = noticeService.pg_list(searchVO);
        int totCnt = noticeService.pg_listCnt();
        System.out.println("전체 게시글 수 : " + totCnt);

        pagination.setTotalRecordCount(totCnt);

        searchVO.setEndDate(pagination.getLastPageNoOnPageList());
        searchVO.setStartDate(pagination.getFirstPageNoOnPageList());
        searchVO.setPrev(pagination.getXprev());
        searchVO.setNext(pagination.getXnext());

        model.addAttribute("pg_list" , pg_list);
        model.addAttribute("totCnt",totCnt);
        model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)searchVO.getPageUnit()));
        model.addAttribute("pagination",pagination);
        return "notice/notice_list";
    }




    //testCtrl
    @RequestMapping("/jtest")
    public String test1(){
        return "z_JeongTest/Jtest";
    }

    @RequestMapping("/jtestmap")
    public String test2(){
        return "z_JeongTest/map1";
    }

    @RequestMapping("/jtestinput")
    public String test3(){
        return "z_JeongTest/putTest";
    }

    //test git commit
    @RequestMapping("/kkk")
    public String kkk(){
        return "kk/kk";
    }
}
