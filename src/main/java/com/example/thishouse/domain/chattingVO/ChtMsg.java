package com.example.thishouse.domain.chattingVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChtMsg {
    private String roomId; // 채팅방 번호
    private String sender;  // 보내는 이
    private String recipient; // 받는 사람
    private String message;  // 메시지 내용
}
