package com.example.thishouse.mincontroller;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Controller
@RequestMapping("/chat")
public class MsgRoomController {

    private final MsgRoomRepository msgRoomRepository;

    //채팅리스트페이지 뷰를 반환해주는 메서드
    @GetMapping("/room")
    public String rooms() {
        System.out.println("화면 전달 완료");
        return "/chat/room";
    }

    public void test(){

    }

    //채팅리스트 데이터만 반환 해주는 메서드
    @GetMapping("/rooms")
    @ResponseBody
    public List<MsgRoom> getChatRooms() {
        return msgRoomRepository.findAllRoom();
    }

    // 채팅방 생성
    @PostMapping("/room")
    @ResponseBody
    public String createRoom(@RequestBody MsgRoom msgRoom)  {
        msgRoomRepository.createMsgRoom(msgRoom);
        return "success111111";
    }

    @GetMapping("/room/{roomId}")
    public String roomInfo(@PathVariable String roomId,Model model) {
        System.out.println("채팅방 조회");
        MsgRoom room = msgRoomRepository.findByRoomId(roomId);
        model.addAttribute("room",room);
        return "/chat/room_detail";
    }
}




