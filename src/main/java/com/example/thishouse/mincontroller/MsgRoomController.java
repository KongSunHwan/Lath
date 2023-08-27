package com.example.thishouse.mincontroller;//package com.example.thishouse.mincontroller;
//
//
//
//import com.example.thishouse.service.RoomService;
//import com.example.thishouse.service.chttingSV.ChtService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RequiredArgsConstructor
//@Controller
//@RequestMapping("/chat")
//public class MsgRoomController {
//
//    private final RoomService roomService;
//
//    //채팅리스트페이지 뷰를 반환해주는 메서드
//    @GetMapping("/room")
//    public String rooms() {
//        System.out.println("화면 전달 완료");
//        return "/chat/room";
//    }
//
//    public void test(){
//            int x =3 ;
//    }
//
//    //채팅리스트 데이터만 반환 해주는 메서드
//    @GetMapping("/rooms")
//    @ResponseBody
//    public List<MsgRoom> getChatRooms() {
//        return roomService.findAllList();
//    }
//
//    // 채팅방 생성
//    @PostMapping("/room")
//    @ResponseBody
//    public String createRoom(@RequestBody MsgRoom msgRoom)  {
//        System.out.println("메서드가 호출되었습니다.");
//        MsgRoom room = MsgRoom.create(msgRoom.getHouse_num(), msgRoom.getBuyerId(), msgRoom.getSellerId());
//        System.out.println(room.getRoomId()+" {룸 아이디 출력");
//        System.out.println(room.getHouse_num()+" 방 이름");
//        chtService.CreateRoomService(room);
//        return "success111111";
//    }
//
//    @GetMapping("/room/{roomId}")
//    public String roomInfo(@PathVariable String roomId,Model model) {
//        System.out.println("채팅방 조회");
//        MsgRoom room = msgRoomRepository.findByRoomId(roomId);
//        model.addAttribute("room",room);
//        return "/chat/room_detail";
//    }
//}
//
//
//
//
