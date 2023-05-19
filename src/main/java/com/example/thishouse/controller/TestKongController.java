package com.example.thishouse.controller;

import com.example.thishouse.domain.community.Community;
import com.example.thishouse.service.BoardService;
import com.example.thishouse.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TestKongController {
    private final BoardService boardService;

    @RequestMapping("board_list")
    public String BoardList(Model model) {
        List<Community> list = boardService.select_board_list();
        model.addAttribute("list", list);
        return "board_test/board_list";
    }

    @RequestMapping("board_detail")
    public String BoardDetail(Model model, String community_num) {
        model.addAttribute("Board", boardService.view_board(community_num));
        return "board_test/board_detail";
    }
}
