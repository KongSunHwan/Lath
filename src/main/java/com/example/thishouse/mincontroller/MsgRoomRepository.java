package com.example.thishouse.mincontroller;//package com.example.thishouse.mincontroller;
//
//
//import jakarta.annotation.PostConstruct;
//import org.springframework.stereotype.Repository;
//
//import java.util.*;
//@Repository
//public class MsgRoomRepository {
//    private Map<String, MsgRoom> msgRoomMap;
//
//    @PostConstruct
//    private void init(){
//        msgRoomMap = new LinkedHashMap<>();
//    }
//
//    public List<MsgRoom> findAllRoom(){
//        //채팅방 생성 순서 최근 순으로 반환
//        List<MsgRoom> msgRooms = new ArrayList<>(msgRoomMap.values());
//        Collections.reverse(msgRooms);
//        return msgRooms;
//    }
//
//    public MsgRoom findByRoomId(String Id){
//
//        return msgRoomMap.get(Id);
//    }
//    public void createMsgRoom(MsgRoom msgRoom){
//        MsgRoom room = MsgRoom.create(msgRoom.getHouse_num(), msgRoom.getBuyerId(), msgRoom.getSellerId());
//        msgRoomMap.put(room.getRoomId(), room);
//    }
//
//}
