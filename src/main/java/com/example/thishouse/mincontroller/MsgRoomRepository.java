package com.example.thishouse.mincontroller;


import com.example.thishouse.domain.chattingVO.ChtRoom;
import com.example.thishouse.service.NoticeService;
import com.example.thishouse.service.chttingSV.ChtService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


import java.util.*;
@Repository
public class MsgRoomRepository {
    private Map<String, MsgRoom> msgRoomMap;

    @PostConstruct
    private void init(){
        msgRoomMap = new LinkedHashMap<>();
    }

    public List<MsgRoom> findAllRoom(){
        //채팅방 생성 순서 최근 순으로 반환
        List<MsgRoom> msgRooms = new ArrayList<>(msgRoomMap.values());
        Collections.reverse(msgRooms);
        return msgRooms;
    }

    public MsgRoom findByRoomId(String Id){

        return msgRoomMap.get(Id);
    }
    public void createMsgRoom(MsgRoom msgRoom){
        MsgRoom room = MsgRoom.create(msgRoom.getName(), msgRoom.getBuyerId(), msgRoom.getSellerId());
        msgRoomMap.put(room.getRoomId(), room);
    }

}
