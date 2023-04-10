package com.example.thishouse.controller;

import com.example.thishouse.domain.Test;
import com.example.thishouse.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService){
        this.testService = testService;
    }

    @GetMapping(value = "/test2")
    public Test test2() throws Exception {
        return testService.test2();
    }

}
