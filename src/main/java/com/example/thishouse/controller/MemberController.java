package com.example.thishouse.controller;

import com.example.thishouse.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
    private final MemberService memberservice; //"final" 키워드가 사용된 이유는, 해당 변수가 생성자를 통해 한 번 초기화되면 그 이후에는 변경되지 않을 것이라는 것을 나타내기 위함

    @Autowired //"@Autowired" 어노테이션을 이용하여 의존성 주입
    public MemberController(MemberService memberservice){ // 이를 통해 "MemberService" 클래스를 사용
        this.memberservice = memberservice;
    }

    @RequestMapping("idCk") // "idCk"라는 이름의 메서드는 HTTP 요청이 들어오면 실행
    @ResponseBody //반환값은 숫자형태로, 클라이언트에서 받아서 처리할 수 있도록 해주는 "@ResponseBody" 어노테이션을 사용
    public int idcheck(HttpServletRequest request, HttpServletResponse response, HttpSession session, String user_id) { // "id"라는 문자열 값을 매개변수로 받습니다.
        System.out.println("idck");
        System.out.println(user_id);
        int result = memberservice.idCk(user_id); // 받은 "id" 값을 이용하여 "MemberService" 클래스에서 "idCk" 메서드를 호출하고, 그 결과를 반환합니다.
        System.out.println(result);
        return result;
    }

}
