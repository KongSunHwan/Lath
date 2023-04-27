package com.example.thishouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {


    @RequestMapping("/map")
    public String map() {
            return "map/map";
    }

    @RequestMapping("/inquire")
    public String inquire() {
        return "inquire/inquire";
    }

    @RequestMapping("/login")
    public String login() {
        return "userlog/login";
    }

    @RequestMapping("/main")
    public String main() {
        return "main/main";
    }

    @RequestMapping("/signup")
    public String signup() {
        return "userlog/signup";
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
        return "real_estate_intro/real_estate_intro";
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
