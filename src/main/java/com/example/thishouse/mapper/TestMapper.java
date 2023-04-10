package com.example.thishouse.mapper;

import com.example.thishouse.domain.Test;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {

    List<Test> test2();
}
