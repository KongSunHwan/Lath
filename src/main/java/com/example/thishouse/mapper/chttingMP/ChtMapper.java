package com.example.thishouse.mapper.chttingMP;

import com.example.thishouse.mincontroller.MsgRoom;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
@RequiredArgsConstructor
public class ChtMapper {
    private final SqlSessionTemplate sqlSession;
    private static final String Namespace = "com.example.thishouse.mapper.chttingMP.ChtMapper";

    //채팅방 DB저장

    public void createChtRoom(MsgRoom msgRoom) {
        System.out.println("채팅방 번호 매퍼" + msgRoom.getRoomId());
         sqlSession.insert(Namespace + ".createChtRoom", msgRoom);
    }
}
