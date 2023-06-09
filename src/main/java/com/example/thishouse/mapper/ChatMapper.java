package com.example.thishouse.mapper;

import com.example.thishouse.domain.ChatRoom;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
@RequiredArgsConstructor
public class ChatMapper {
    private final SqlSessionTemplate sqlSession;
    private static final String Namespace = "com.example.thishouse.mapper.ChatMapper";

    public int sequence() {
        return sqlSession.selectOne(Namespace+".sequence");
    }

    public List<ChatRoom> findAllRooms() {
        return sqlSession.selectList(Namespace+".findAllRooms");
    }

    public ChatRoom findRoomById(String roomId) {
        return sqlSession.selectOne(Namespace+".findRoomById", roomId);
    }

    public int createChatRoom(ChatRoom chatRoom) {
        return sqlSession.insert(Namespace+".createChatRoom", chatRoom);
    }

}
