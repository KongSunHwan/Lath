package com.example.thishouse.controller;

import com.example.thishouse.domain.Criteria;
import com.example.thishouse.domain.DTO.NoticeDTO;
import com.example.thishouse.domain.community.CommunityDTO;
import com.example.thishouse.util.PageCtrl;
import com.example.thishouse.domain.community.Community;
import com.example.thishouse.domain.community.Community_reply;
import com.example.thishouse.service.CommunityService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CommunityController {

    private final CommunityService communityService;

    //게시판 상세 조회
    @RequestMapping("/board_detail")
    public String board_detail(Model model, String community_num,
                               @ModelAttribute("Cri") Criteria criteria) {
        communityService.update_board_hitCount(community_num);
        model.addAttribute("Board", communityService.view_board(community_num));
        model.addAttribute("reply", communityService.view_reply(community_num));
        return "board/board_detail";
    }

    @RequestMapping("reply_add")
    public String ReplyAdd(HttpServletRequest request,
                           @ModelAttribute("Cri") Criteria criteria,
                           RedirectAttributes redirectAttributes){
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
        redirectAttributes.addAttribute("pageNum", criteria.getPageNum());
        redirectAttributes.addAttribute("amount", criteria.getAmount());
        redirectAttributes.addAttribute("type", criteria.getType());
        redirectAttributes.addAttribute("keyword", criteria.getKeyword());
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
    public String board_edit(Model model, String community_num,
                             @ModelAttribute("Cri") Criteria criteria) {
        log.info("Cri={}", criteria);
        model.addAttribute("Board", communityService.view_board(community_num));
        return "board/board_edit";
    }

    //게시판 수정 기능
    @PostMapping("board_edit")
    public String board_edit(@ModelAttribute("Cri") Criteria criteria, Community community,
                             RedirectAttributes redirectAttributes) {
        communityService.update_board(community);
        log.info("criteria={}", criteria);
        redirectAttributes.addAttribute("community_num", community.getCommunity_num());
        redirectAttributes.addAttribute("pageNum", criteria.getPageNum());
        redirectAttributes.addAttribute("amount", criteria.getAmount());
        redirectAttributes.addAttribute("type", criteria.getType());
        redirectAttributes.addAttribute("keyword", criteria.getKeyword());
        return "redirect:/board_detail";
    }

    @RequestMapping("board_delete")
    public String board_delete(String community_num) {
        communityService.delete_board(community_num);
        return "redirect:/board_list";
    }
    @RequestMapping("/board_list")
    public String pgList(Criteria criteria, Model model) {
        CommunityDTO.PageResponseList pageResponseList = communityService.pageResponseLists(criteria);
        model.addAttribute("pageList", pageResponseList);
        return "board/board_list";
    }
}
