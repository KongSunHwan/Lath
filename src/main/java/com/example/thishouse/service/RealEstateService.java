package com.example.thishouse.service;

import com.example.thishouse.domain.Member;
import com.example.thishouse.mapper.MemberMapper;
import com.example.thishouse.mapper.RealEstateMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RealEstateService {

    private final RealEstateMapper realEstateMapper;
    //매물등록*
    //매물 리스트 페이징*
    //매물 상세내용*
    //매물검색 + 필터*



}
