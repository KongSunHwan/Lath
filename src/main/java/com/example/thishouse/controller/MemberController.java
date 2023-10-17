package com.example.thishouse.controller;

import com.example.thishouse.domain.Inquire;
import com.example.thishouse.domain.Member;
import com.example.thishouse.domain.Report;
import com.example.thishouse.domain.community.Community;
import com.example.thishouse.domain.contract.Contract;
import com.example.thishouse.service.ContractService;
import com.example.thishouse.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final ContractService contractService;

    //회원가입,로그인 로직
    @PostMapping("/signup")
    public String signup(@Validated @ModelAttribute Member member, BindingResult bindingResult) {
        //검증 실패
        if (bindingResult.hasErrors()) {
            return "main/signup";
        }
        memberService.sign_up(member);

        return "redirect:/login";
    }

    @RequestMapping("idCk") // "idCk"라는 이름의 메서드는 HTTP 요청이 들어오면 실행
    @ResponseBody //반환값은 숫자형태로, 클라이언트에서 받아서 처리할 수 있도록 해주는 "@ResponseBody" 어노테이션을 사용
    public int idcheck(String user_id) { // "id"라는 문자열 값을 매개변수로 받습니다.
        int result = memberService.idCk(user_id); // 받은 "id" 값을 이용하여 "MemberService" 클래스에서 "idCk" 메서드를 호출하고, 그 결과를 반환합니다.
        return result;
    }

    @PostMapping("/main/login")
    public String login(Member member, HttpSession session, Model model) {
        int ck = memberService.loginMember(member);
        if (ck == 0) { // 로그인 실패
            return "redirect:/login";

        } else {
            session.setAttribute("user_id", member.getUser_id());
            return "redirect:/main";
        }
    }

    //문의사항
    @RequestMapping("/user_inquire")
    public String test2_inquire(HttpServletRequest request,String user_id, Model model) {
        HttpSession session = request.getSession(false);

        if(session == null){
            return "redirect:/login";
        }else {
            List<Inquire> my_inquire = memberService.findInputMemberInquire(user_id);
            model.addAttribute("my_inquire",my_inquire);
            return "user/inquire";
        }
    }

    @RequestMapping("/inquire_insert")
    public String inquire_insert(Inquire inquire,HttpSession session) {
        String user_id = (String) session.getAttribute("user_id"); //구매자
        String url = "redirect:/user_inquire?user_id=";
        memberService.inquire_insert(inquire);
        return url + user_id;
    }

    @RequestMapping("/mypage")
    public String mypage(String user_id, Model model) {
        List<Community> comlist = memberService.my_community(user_id);
        List<Report> replist = memberService.findInputMemberReport(user_id);
        List<Inquire> inquireList = memberService.my_inquire_one(user_id);
        int house_cnt = memberService.house_cnt(user_id);
        int report_cnt = memberService.report_cnt(user_id);
        String get_tenant_id = contractService.get_tenant_id(user_id);
        String get_lessoer_id = contractService.get_lessoer_id(user_id);

        int contract_request_cnt;
        int contract_accept_cnt;

        if (get_tenant_id==null){
            contract_request_cnt = 0;
        }else{
            contract_request_cnt = contractService.get_contract_request(get_tenant_id);
        }

        if (get_lessoer_id==null){
            contract_accept_cnt = 0;
        }else{
            contract_accept_cnt = contractService.get_contract_accept(get_tenant_id);
        }

        model.addAttribute("contract_request_cnt", contract_request_cnt);
        model.addAttribute("contract_accept_cnt", contract_accept_cnt);

        model.addAttribute("house_cnt", house_cnt);
        model.addAttribute("report_cnt", report_cnt);
        model.addAttribute("comlist", comlist);
        model.addAttribute("replist", replist);
        model.addAttribute("Member", memberService.findInputMember(user_id));
        model.addAttribute("inquireList", inquireList);
        return "user/mypage";
    }



}
