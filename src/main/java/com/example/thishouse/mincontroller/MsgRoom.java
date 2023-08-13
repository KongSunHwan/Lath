package com.example.thishouse.mincontroller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class MsgRoom {


    private String roomId;

    private String name;
    private String buyerId;  // 구매자
    private String sellerId;  // 판매자
    private Set<WebSocketSession> sessions = new HashSet<>();
    //WebSocketSession은 Spring에서 Websocket Connection이 맺어진 세션

    public static MsgRoom create(String name,String buyerId,String sellerId){
        MsgRoom msgRoom = new MsgRoom();
        msgRoom.roomId = UUID.randomUUID().toString();
        msgRoom.name = name;
        msgRoom.buyerId = buyerId;
        msgRoom.sellerId = sellerId;
        return msgRoom;
    }





}
