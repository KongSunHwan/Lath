package com.example.thishouse.mapper;

import com.example.thishouse.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
//interface사용시 오류 (required_bean error)
@Repository
public class MemberMapper {
    public void sign_up(Member member) {
        System.out.println("Mapper");
    }
}
