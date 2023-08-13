package com.example.thishouse.mincontroller;



import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketSession;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
public class MsgController {

  private final SimpMessagingTemplate template;



  // 클라이언트가 /pub/chat/enter로 메시지를 보낼 때의 처리
  @MessageMapping("/chat/enter")
  public void enter(Message message) {
    message.setMessage(message.getSender() + "님입니다.");
    template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);

  }


  // 클라이언트가 /pub/chat/message로 메시지를 보낼 때의 처리
  @MessageMapping("/chat/message")
  public void message(Message message){
    System.out.println("message 내용 = " + message.getMessage());
    System.out.println("message 방번호 = " + message.getRoomId());
    System.out.println("message 받는 사람 = "+ message.getRecipient());
    template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);

  }

}
