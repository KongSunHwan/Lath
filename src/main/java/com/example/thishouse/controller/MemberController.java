package com.example.thishouse.controller;

import com.example.thishouse.service.MemberService;
import com.example.thishouse.service.TestService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
    private final MemberService memberservice;

    @Autowired
    public MemberController(MemberService memberservice){
        this.memberservice = memberservice;
    }

    @RequestMapping("idCk")
    @ResponseBody
    public int idcheck(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String id) {
        System.out.println("idck");
        System.out.println(id);
        int result = memberservice.idCk(id);
        System.out.println(result);
        return result;
    }

}
