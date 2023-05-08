package com.example.thishouse.service;

import com.example.thishouse.mapper.AdminMapper;
import com.example.thishouse.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdminService {
    private final AdminMapper adminMapper;
    //table 전체
}
