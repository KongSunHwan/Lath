package com.example.thishouse.service;

import com.example.thishouse.domain.house.*;
import com.example.thishouse.mapper.RealEstateMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RealEstateService {

    private final RealEstateMapper realEstateMapper;
    //시퀸스 생성
    public int sequence() {
        int result = realEstateMapper.sequence();
        return result;
    }
    //매물등록*
    //매물 기본
    @Transactional
    public void insert_house_item(House_item houseItem) {
        this.realEstateMapper.insert_house_item(houseItem);
    }

    //매물내용
    @Transactional
    public void insert_house_type(House_type house_type) {
        System.out.println("TEST CON SER================");
        this.realEstateMapper.insert_house_type(house_type);
    }

    @Transactional
    public void insert_house_location(House_location house_location) {
        this.realEstateMapper.insert_house_location(house_location);
    }

    @Transactional
    public void insert_house_deal(House_deal house_deal) {
        this.realEstateMapper.insert_house_deal(house_deal);
    }

    @Transactional
    public void insert_house_info(House_info house_info) {
        this.realEstateMapper.insert_house_info(house_info);
    }

    @Transactional
    public void insert_house_addinfo(House_addinfo house_addinfo) {
        this.realEstateMapper.insert_house_addinfo(house_addinfo);
    }

    @Transactional
    public void insert_house_option(House_option house_option) {
        this.realEstateMapper.insert_house_option(house_option);
    }

    @Transactional
    public void insert_house_detail(House_detail house_detail) {
        this.realEstateMapper.insert_house_detail(house_detail);
    }

    @Transactional
    public void insert_picture(House_picture house_picture) {
        this.realEstateMapper.insert_picture(house_picture);
    }
    //매물요약
    @Transactional
    public void insert_house_list(House_list house_list) {
        this.realEstateMapper.insert_house_list(house_list);
    }

    //매물 사진

    public List<House_list> view_house_list() {
        return this.realEstateMapper.view_house_list();
    }

    public List<House_picture> getHousePictures() {
        return this.realEstateMapper.getHousePictures();
    }

    public Resource loadFileAsResource(String filePath) throws FileNotFoundException {
        try {
            Path file = Paths.get(filePath);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new FileNotFoundException("Could not read file: " + filePath);
            }
        } catch (MalformedURLException e) {
            throw new FileNotFoundException("Could not read file: " + filePath);
        }
    }

    //wish list

    //매물 리스트 페이징*
    //매물 상세내용*

    //매물검색 + 필터*



}
