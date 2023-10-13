package com.example.thishouse.mapper;


import com.example.thishouse.domain.Marker;
import com.example.thishouse.domain.Message;
import com.example.thishouse.domain.house.House_list;
import com.example.thishouse.domain.house.MapVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Mapper
public interface MarkerMapper {
    public void insertMarker(Marker marker);

    public List<HashMap>  getMarkers();

    public List<HashMap> map_filter(House_list houseList);

    public List<HashMap> all_map();

//    public List<MapVO> map_all_filter(House_list houseList);
    public List<HashMap> map_all_house_type_filter(House_list houseList);
    public List<HashMap> map_all_deal_type_filter(House_list houseList);
}
