package com.example.thishouse.controller;

import com.example.thishouse.domain.Member;
import com.example.thishouse.mapper.MemberMapper;
import com.example.thishouse.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MemberService memberService;
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
        Long id = (Long) session.getAttribute("user_id");
        if (id != null) // 로그인된 상태
        {
            return "redirect:/";
        }
        return "userlog/login"; // 로그인되지 않은 상태
    }

    @PostMapping("/login")
    public String login(Member member, HttpSession session) {
        int ck = memberService.loginMember(member);
        if (ck == 0) { // 로그인 실패
            return "redirect:/login";
        }
        session.setAttribute("user_id", member.getUser_id());
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
        memberService.sign_up(member);
        return "redirect:/login";
    }

    @RequestMapping("idCk") // "idCk"라는 이름의 메서드는 HTTP 요청이 들어오면 실행
    @ResponseBody //반환값은 숫자형태로, 클라이언트에서 받아서 처리할 수 있도록 해주는 "@ResponseBody" 어노테이션을 사용
    public int idcheck(HttpServletRequest request, HttpServletResponse response, HttpSession session, String user_id) { // "id"라는 문자열 값을 매개변수로 받습니다.
        int result = memberService.idCk(user_id); // 받은 "id" 값을 이용하여 "MemberService" 클래스에서 "idCk" 메서드를 호출하고, 그 결과를 반환합니다.
        return result;
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

    @RequestMapping("/mypage")
    public String mypage() {
        return "user_mypage/mypage";
    }
}
