package com.example.thishouse.service;

import com.example.thishouse.domain.ChatRoom;
import com.example.thishouse.mapper.ChatMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class ChatService {

    private Map<String, ChatRoom> chatRoomMap;

    private final ChatMapper chatMapper;

    @PostConstruct
    private void init() {
        chatRoomMap = new LinkedHashMap<>();
    }

    // 모든 채팅방 조회
    public List<ChatRoom> findAllRooms() {
        // 최신순으로 채팅방 생성 순서대로 반환
        List<ChatRoom> chatRooms = new ArrayList<>(chatRoomMap.values());
        Collections.reverse(chatRooms);
        return chatRooms;
    }

    // 채팅방 ID로 채팅방 조회
    public ChatRoom findRoomById(String roomId) {
        return chatRoomMap.get(roomId);
    }

    // 채팅방 생성
    public ChatRoom createChatRoom(String roomName) {
        ChatRoom chatRoom = new ChatRoom().create(roomName);
        chatRoomMap.put(chatRoom.getRoomId(), chatRoom);
        return chatRoom;
    }

    // 채팅방 유저 수 증가
    public void increaseUserCount(String roomId) {
        ChatRoom room = chatRoomMap.get(roomId);
        room.setUserCount(room.getUserCount() + 1);
    }

    // 채팅방 유저 수 감소
    public void decreaseUserCount(String roomId) {
        ChatRoom room = chatRoomMap.get(roomId);
        room.setUserCount(room.getUserCount() - 1);
    }

    // 채팅방에 유저 추가
    public String addUser(String roomId, String userName) {
        ChatRoom room = chatRoomMap.get(roomId);
        String userUUID = UUID.randomUUID().toString();
        room.getUserList().put(userUUID, userName);
        return userUUID;
    }

    // 중복된 채팅방 유저 이름 확인
    public String checkDuplicateName(String roomId, String username) {
        ChatRoom room = chatRoomMap.get(roomId);
        String tmp = username;
        while (room.getUserList().containsValue(tmp)) {
            int ranNum = (int) (Math.random() * 100) + 1;
            tmp = username + ranNum;
        }
        return tmp;
    }

    // 채팅방 유저 제거
    public void removeUser(String roomId, String userUUID) {
        ChatRoom room = chatRoomMap.get(roomId);
        room.getUserList().remove(userUUID);
    }

    // 채팅방 유저 이름 조회
    public String getUserName(String roomId, String userUUID) {
        ChatRoom room = chatRoomMap.get(roomId);
        return room.getUserList().get(userUUID);
    }

    // 모든 채팅방의 유저 리스트 조회
    public List<String> getUserList(String roomId) {
        List<String> list = new ArrayList<>();
        ChatRoom room = chatRoomMap.get(roomId);
        room.getUserList().forEach((key, value) -> list.add(value));
        return list;
    }
}
