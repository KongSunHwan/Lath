package com.example.thishouse.mapper;

import com.example.thishouse.domain.Test;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //Mapper.xml에 있는 것을 매핑
public interface MemberMapper {

    int idCk(String id);
}
