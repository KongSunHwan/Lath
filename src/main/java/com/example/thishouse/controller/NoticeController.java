package com.example.thishouse.controller;

import com.example.thishouse.domain.Criteria;
import com.example.thishouse.domain.DTO.NoticeDTO;
import com.example.thishouse.domain.Notice;
import com.example.thishouse.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Slf4j
@Controller
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;
    @RequestMapping("/notice_detail")
    public String NoticeDetail(Model model, String notice_num,
                               @ModelAttribute("Cri") Criteria criteria) {
        log.info("critera={}", criteria);
        noticeService.update_notice_hitCount(notice_num);
        model.addAttribute("Notice", noticeService.view_notice(notice_num));
        return "notice/notice_detail";
    }
    @GetMapping("/notice_add")
    public String BoardAdd(Notice notice) {
        noticeService.insert_notice(notice);
        return "redirect:/notice_list";
    }
    @RequestMapping("/notice_edit")
    public String NoticeUpdateView(Model model, String notice_num,
                                   @ModelAttribute("Cri") Criteria criteria) {
        model.addAttribute("Notice", noticeService.view_notice(notice_num));
        return "notice/notice_edit";
    }

    @RequestMapping("/notice_delete")
    public String NoticeDelete(String notice_num, Criteria criteria,
                               RedirectAttributes rttr) {
        noticeService.delete_notice(notice_num);
        rttr.addAttribute("pageNum", criteria.getPageNum());
        rttr.addAttribute("amount", criteria.getAmount());
        return "redirect:/notice_list";
    }

    @RequestMapping("/notice_list")
    public String pgList(Criteria criteria, Model model) {
        NoticeDTO.PageResponseList pageResponseList = noticeService.pageResponseList(criteria);
        model.addAttribute("pageList", pageResponseList);
        return "notice/notice_list";
    }
}
