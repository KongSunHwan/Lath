package com.example.thishouse.repository;

import com.example.thishouse.domain.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDaoImpl implements TestDao {

    private final SqlSessionTemplate sqlSession;

    private static final String Namespace = "com.example.thishouse.mapper.TestMapper";

    @Autowired
    TestDaoImpl(SqlSessionTemplate sqlSession){
        this.sqlSession = sqlSession;
    }

    @Override
    public Test test2() {
        return sqlSession.selectOne(Namespace+".test2");
    }
}
