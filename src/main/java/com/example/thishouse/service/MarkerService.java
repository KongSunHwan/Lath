package com.example.thishouse.service;

import com.example.thishouse.domain.house.House_list;
import com.example.thishouse.mapper.MarkerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MarkerService {

    private final MarkerMapper markerMapper;

//    public void insertMarker(Marker marker) {
//        markerMapper.insertMarker(marker);
//    }

    public List<HashMap>  getMarkers() {
        return markerMapper.getMarkers();
    }

    public List<HashMap> map_filter(House_list houseList) {
        return markerMapper.map_filter(houseList);
    }

    public List<HashMap> all_map() {
        return markerMapper.all_map();
    }

//    public List<MapVO> map_all_filter(House_list houseList) {
//        return markerMapper.map_all_filter(houseList);
//    }

    public List<HashMap> map_all_house_type_filter(House_list houseList) {
        return markerMapper.map_all_house_type_filter(houseList);

    }

    public List<HashMap> map_all_deal_type_filter(House_list houseList) {
        return markerMapper.map_all_deal_type_filter(houseList);

    }
}
