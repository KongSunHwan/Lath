package com.example.thishouse.domain.chattingVO;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ChtRoom {
    private String roomId;
    private String name;
    private String buyerId;  // 구매자
    private String sellerId;  // 판매자

    public static ChtRoom create(String name, String buyerId, String sellerId){
        ChtRoom chtRoom = new ChtRoom();
        chtRoom.roomId = UUID.randomUUID().toString();
        chtRoom.name = name;
        chtRoom.buyerId = buyerId;
        chtRoom.sellerId = sellerId;
        return chtRoom;
    }
}
