package com.example.thishouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {


    @RequestMapping("/map")
    public String map() {
            return "map";
    }

    @RequestMapping("/inquire")
    public String inquire() {
        return "inquire";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    @RequestMapping("/signup")
    public String signup() {
        return "signup";
    }

    @RequestMapping("/steamed_list")
    public String steamed_list() {
        return "steamed_list";
    }

    @RequestMapping("/real_estate_add")
    public String real_estate_add() {
        return "real_estate_add";
    }

    @RequestMapping("/lecture_intro")
    public String lecture_intro() {
        return "lecture_intro";
    }

    @RequestMapping("/header")
    public String header() {
        return "header";
    }

    @RequestMapping("/footer")
    public String footer() {
        return "footer";
    }

    @RequestMapping("/notice_add")
    public String notice_add() {
        return "notice_add";
    }

    @RequestMapping("/notice_detail")
    public String notice_detail() {
        return "notice_detail";
    }

    @RequestMapping("/notice_edit")
    public String notice_edit() {
        return "notice_edit";
    }

    @RequestMapping("/notice_list")
    public String notice_list() {
        return "notice_list";
    }
}
