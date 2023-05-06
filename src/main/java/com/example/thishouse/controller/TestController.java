package com.example.thishouse.controller;

import com.example.thishouse.domain.Member;
import com.example.thishouse.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class TestController {

    private final MemberService memberservice;

    @RequestMapping("/sign_up_test")
    public String sign_up() {
        System.out.println("CON : page");
        return "test_html/sign_up_test";
    }

    @PostMapping("/sign_up_test")
    public String sign_up(Member member) {
        memberservice.sign_up(member);
        return "test_html/sign_up_complete";
    }

}
