package com.example.thishouse.controller;

import com.example.thishouse.util.PageCtrl;
import com.example.thishouse.domain.Member;
import com.example.thishouse.domain.house.House_list;
import com.example.thishouse.service.HouseService;
import com.example.thishouse.service.MarkerService;
import com.example.thishouse.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MarkerService markerService;
    private final HouseService houseService;

    //지도 Map
    @GetMapping("/map")
    public String map(Model model) {
        List<HashMap> markers = markerService.getMarkers();
        model.addAttribute("markers", markers);
        return "main/map";
    }

    @GetMapping("/map_filter")
    public String map_fillter(Model model, House_list house_list) {
        List<HashMap> mapall = null;
        List<HashMap> markers = null;

        if(house_list.getHouse_type().equals("전체") && house_list.getDeal_type().equals("전체")){
            markers = markerService.getMarkers();
            mapall=markerService.all_map();

        }else if(house_list.getHouse_type().equals("전체")){
            markers = markerService.map_all_house_type_filter(house_list);
        }else if( house_list.getDeal_type().equals("전체")){
            markers = markerService.map_all_deal_type_filter(house_list);
        }else{
            markers = markerService.map_filter(house_list);
        }
        model.addAttribute("markers", markers);
        model.addAttribute("mapall", mapall);

        return "main/map";
    }

    //회원가입,로그인 창 이동
    @GetMapping("/login")
    public String login() {
        return "main/login"; // 로그인되지 않은 상태
    }

    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("member", new Member());
        return "main/signup";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session,Model model) {
        session.invalidate();
        return "redirect:/main";
    }
    
    //부동산 관련
    @RequestMapping("/main")
    public String main(@ModelAttribute("searchVO") House_list searchVO, HttpServletRequest request, Model model) {

        PageCtrl pagination  = new PageCtrl();
        pagination.setCurrentPageNo(searchVO.getPageIndex());
        pagination.setRecordCountPerPage(searchVO.getPageUnit_house());
        pagination.setPageSize(searchVO.getPageSize());
        searchVO.setFirstIndex(pagination.getFirstRecordIndex());
        searchVO.setRecordCountPerPage(pagination.getRecordCountPerPage());
        String context = request.getParameter("searchValue");

        if(context == null){
            List<HashMap> house_list = houseService.house_list_pg(searchVO);
            model.addAttribute("house_list" , house_list);
            int totCnt = houseService.house_list_pg_cnt();
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
            List<HashMap> house_list = houseService.house_list_pg(searchVO);
            model.addAttribute("house_list" , house_list);
            int totCnt = houseService.house_list_pg_cnt();
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
            searchVO.setSearch_content(context);
            List<HashMap> house_list = houseService.house_search_pg(searchVO);
            model.addAttribute("house_list" , house_list);
            int totCnt = houseService.house_search_pg_cnt(searchVO);
            model.addAttribute("totCnt",totCnt);
            pagination.setTotalRecordCount(totCnt);
            searchVO.setEndDate(pagination.getLastPageNoOnPageList());
            searchVO.setStartDate(pagination.getFirstPageNoOnPageList());
            searchVO.setPrev(pagination.getXprev());
            searchVO.setNext(pagination.getXnext());
            model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)searchVO.getPageUnit()));
            model.addAttribute("pagination",pagination);
        }
        return "main/main";
    }

    @RequestMapping("/house_add")
    public String house_add(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session == null){
            return "redirect:/login";
        }
        return "house/house_add";
    }




}
