package com.example.thishouse.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository

public class MemberDaoImpl implements MemberDao{
    private final SqlSessionTemplate sqlSession;

    private static final String Namespace = "com.example.thishouse.mapper.MemberMapper";

    @Autowired
    MemberDaoImpl(SqlSessionTemplate sqlSession){
        this.sqlSession = sqlSession;
    }

    //중복확인
    @Override
    public int idCk(String id) {
        System.out.println(id + " DAO");
        int result = sqlSession.selectOne(Namespace+".idCk",id);
        System.out.println(result);
        return result;
    }
    
}
