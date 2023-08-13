package com.example.thishouse.mincontroller;


import lombok.Getter;
import lombok.Setter;


//채팅 메시지를 주고받기 위한 DTO
//채팅방 입장, 채팅방에 메시지 보내기 두가지 상황에 맞춰 enum을 구현
//방 번호 , 보는내는 사람, 내용
@Getter
@Setter
public class Message {


    private String roomId; // 채팅방 번호
    private String sender;  // 보내는 이
    private String recipient; // 받는 사람 
    private String message;  // 메시지 내용


}
