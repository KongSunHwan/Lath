package com.example.thishouse.service.chttingSV;


import com.example.thishouse.mapper.chttingMP.ChtMapper;
import com.example.thishouse.mincontroller.MsgRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ChtService {
    private final ChtMapper chtMapping;

    @Transactional
    public void CreateRoomService(MsgRoom msgRoom) {
        this.chtMapping.createChtRoom(msgRoom);
    }

}
