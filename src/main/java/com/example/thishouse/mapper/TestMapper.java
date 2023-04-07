package com.example.thishouse.mapper;

import com.example.thishouse.domain.testDTO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface TestMapper {

    public int insertTest(testDTO params);
}
