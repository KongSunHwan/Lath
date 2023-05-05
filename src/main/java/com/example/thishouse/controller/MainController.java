package com.example.thishouse.controller;

import com.example.thishouse.domain.Member;
import com.example.thishouse.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {


    @RequestMapping("/map")
    public String map() {
            return "map/map";
    }

    @RequestMapping("/inquire")
    public String inquire() {
        return "inquire/inquire";
    }

    @GetMapping("/login")
    public String login(HttpSession session) {
        Long id = (Long) session.getAttribute("userId");
        if (id != null) // 로그인된 상태
        {
            return "redirect:/";
        }
        return "userlog/login"; // 로그인되지 않은 상태
    }

    @PostMapping("/login")
    public String login(String user_id, String user_pw, String user_name, HttpSession session) {
        Long id =MemberService.loginMember(user_id, user_pw, user_name);
        if (id == null) { // 로그인 실패
            return "redirect:/login";
        }
        session.setAttribute("user_id", id);
        return "redirect:/main";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @RequestMapping("/main")
    public String main() {
        return "main/main";
    }

    @GetMapping("/signup")
    public String signupForm() {
        return "userlog/signup";
    }

    @PostMapping("/signup")
    public String signup(Member member) {
        MemberService.signupMember(member);
        return "redirect:/login";
    }

    @RequestMapping("/steamed_list")
    public String steamed_list() {
        return "steamed/steamed_list";
    }

    @RequestMapping("/real_estate_add")
    public String real_estate_add() {
        return "real_estate/real_estate_add";
    }

    @RequestMapping("/real_estate_intro")
    public String real_estate_intro() {
        return "real_estate/real_estate_intro";
    }

    @RequestMapping("/header")
    public String header() {
        return "header/header";
    }

    @RequestMapping("/footer")
    public String footer() {
        return "footer/footer";
    }

    @RequestMapping("/notice_add")
    public String notice_add() {
        return "notice/notice_add";
    }

    @RequestMapping("/notice_detail")
    public String notice_detail() {
        return "notice/notice_detail";
    }

    @RequestMapping("/notice_edit")
    public String notice_edit() {
        return "notice/notice_edit";
    }

    @RequestMapping("/notice_list")
    public String notice_list() {
        return "notice/notice_list";
    }
}
