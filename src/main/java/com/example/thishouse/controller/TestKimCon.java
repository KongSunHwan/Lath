package com.example.thishouse.controller;

import com.example.thishouse.domain.community.Community;
import com.example.thishouse.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TestKimCon {
    private final MemberService memberService;

    //내게시글 test
    @RequestMapping("/test_my_community")
    public String test_my_community(String user_id, Model model) {
        System.out.println("con : "+user_id);
        List<Community> list = memberService.my_community(user_id);
        System.out.println(list);
        model.addAttribute("list",list);
        System.out.println(list);
        return "test_kim/my_community";
    }





}
