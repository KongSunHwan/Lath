package com.example.thishouse.mapper;

import com.example.thishouse.domain.Marker;
import com.example.thishouse.domain.Member;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
@RequiredArgsConstructor
public class MarkerMapper {
    private final SqlSessionTemplate sqlSession;

    private static final String Namespace = "com.example.thishouse.mapper.MarkerMapper";

    public void insertMarker(Marker marker) {
        sqlSession.insert(Namespace+".insertMarker", marker);
    }

    public List<Marker> getMarkers() {
        return sqlSession.selectList(Namespace+".getMarkers");
    }
}
