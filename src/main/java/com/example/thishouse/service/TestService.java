package com.example.thishouse.service;

import com.example.thishouse.domain.Test;
import com.example.thishouse.repository.TestDao;
import com.example.thishouse.repository.TestDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private final TestDao testDao;

    @Autowired
    public TestService(TestDaoImpl testDao){
        this.testDao = testDao;
    }

    public Test test2() throws Exception {
        return testDao.test2();
    }
}
