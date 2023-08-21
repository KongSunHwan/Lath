package com.example.thishouse.service;

import com.example.thishouse.domain.Marker;
import com.example.thishouse.domain.house.House_list;
import com.example.thishouse.domain.house.MapVO;
import com.example.thishouse.mapper.MarkerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MarkerService {

    private final MarkerMapper markerMapper;

    public void insertMarker(Marker marker) {
        markerMapper.insertMarker(marker);
    }

    public List<MapVO> getMarkers() {
        return markerMapper.getMarkers();
    }

    public List<MapVO> map_fillter(House_list houseList) {
        return markerMapper.map_fillter(houseList);
    }
}
