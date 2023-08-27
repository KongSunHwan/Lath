package com.example.thishouse.mincontroller;//package com.example.thishouse.mincontroller;
//
//
//
//import com.example.thishouse.domain.ChatSession;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.stereotype.Controller;
//
//import java.util.Objects;
//
//@Controller
//@RequiredArgsConstructor
//@Log4j2
//public class MsgController {
//
//  private final SimpMessagingTemplate template;
//
//
//
//  // 클라이언트가 /pub/chat/enter로 메시지를 보낼 때의 처리
//  @MessageMapping("/chat/enter")
//  public void enter(Message message, SimpMessageHeaderAccessor accessor) {
//    ChatSession chatSession = (ChatSession) accessor.getSessionAttributes().get("chatSession");
//    String sessionId = chatSession.getSessionId();
//    String username = chatSession.getUsername();
//    System.out.println("sessionId = " + sessionId);
//    System.out.println("username = " + username);
//    message.setMsg(message.getSender() + "님입니다.");
//    template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
//
//  }
//
//
//  // 클라이언트가 /pub/chat/message로 메시지를 보낼 때의 처리
//  @MessageMapping("/chat/message")
//  public void message(Message message){
//    template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
//
//  }
//
//}
