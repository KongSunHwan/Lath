package com.example.thishouse.service;

import com.example.thishouse.domain.house.*;
import com.example.thishouse.mapper.HouseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HouseService {

    private final HouseMapper houseMapper;
    //시퀸스 생성
    public int sequence() {
        int result = houseMapper.sequence();
        return result;
    }
    //매물등록*
    //매물 기본
    @Transactional
    public void insert_house_item(House_item houseItem) {
        this.houseMapper.insert_house_item(houseItem);
    }

    //매물내용
    @Transactional
    public void insert_house_type(House_type house_type) {
        System.out.println("TEST CON SER================");
        this.houseMapper.insert_house_type(house_type);
    }

    @Transactional
    public void insert_house_location(House_location house_location) {
        this.houseMapper.insert_house_location(house_location);
    }

    @Transactional
    public void insert_house_deal(House_deal house_deal) {
        this.houseMapper.insert_house_deal(house_deal);
    }

    @Transactional
    public void insert_house_info(House_info house_info) {
        this.houseMapper.insert_house_info(house_info);
    }

    @Transactional
    public void insert_house_addinfo(House_addinfo house_addinfo) {
        this.houseMapper.insert_house_addinfo(house_addinfo);
    }

    @Transactional
    public void insert_house_option(House_option house_option) {
        this.houseMapper.insert_house_option(house_option);
    }

    @Transactional
    public void insert_house_detail(House_detail house_detail) {
        this.houseMapper.insert_house_detail(house_detail);
    }

    @Transactional
    public void insert_picture(House_picture house_picture) {
        this.houseMapper.insert_picture(house_picture);
    }
    //매물요약
    @Transactional
    public void insert_house_list(House_list house_list) {
        this.houseMapper.insert_house_list(house_list);
    }

    //매물 사진

    public List<HashMap> view_house_list() {
        return this.houseMapper.view_house_list();
    }

    public List<House_picture> getHousePictures() {
        return this.houseMapper.getHousePictures();
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

    public List<House_list> view_house_list_one(String house_num) {
            return this.houseMapper.view_house_list_one(house_num);
    }
    public List<House_item> list_house_item(String house_num) {
        return this.houseMapper.list_house_item(house_num);
    }

    public List<House_addinfo> add_info_list(String houseNum) {
        return this.houseMapper.add_info_list(houseNum);
    }

    public List<House_detail> house_detail_list(String houseNum) {
        return this.houseMapper.house_detail_list(houseNum);
    }

    public List<House_option> house_option_list(String houseNum) {
        return this.houseMapper.house_option_list(houseNum);

    }

    public List<House_info> house_info_list(String houseNum) {
        return this.houseMapper.house_info_list(houseNum);
    }

    public List<House_type> house_type_list(String houseNum) {
        return this.houseMapper.house_type_list(houseNum);
    }

    public String road_address(String houseNum) {
        return this.houseMapper.road_address(houseNum);
    }

    public List<House_picture> house_picture_list(String houseNum) {
        return this.houseMapper.house_picture_list(houseNum);
    }

    public List<HashMap> house_list_pg(House_list searchVO) {
        return this.houseMapper.house_list_pg(searchVO);
    }

    public int house_list_pg_cnt() {
        return this.houseMapper.house_list_pg_cnt();
    }

    public List<HashMap> house_search_pg(House_list searchVO) {
        return this.houseMapper.house_search_pg(searchVO);
    }

    public int house_search_pg_cnt(House_list searchVO) {
        return this.houseMapper.house_search_pg_cnt(searchVO);
    }

    @Transactional
    public void house_hit_coount(String houseNum) {
        this.houseMapper.house_hit_coount(houseNum);
    }



    public String deal_type(String houseNum) {
        return this.houseMapper.deal_type(houseNum);
    }

    public List<House_location> house_location(String houseNum) {
        return this.houseMapper.house_location(houseNum);
    }

    public String house_type(String houseNum) {
        return this.houseMapper.house_type(houseNum);
    }

    public int user_house_list_pg_cnt(String user_id) {
        return this.houseMapper.user_house_list_pg_cnt(user_id);
    }

    public List<HashMap> user_house_list_pg(House_list searchVO) {
        return this.houseMapper.user_house_list_pg(searchVO);
    }

    public HashMap get_house_info(String houseNum) {
        return this.houseMapper.get_house_info(houseNum);

    }
}
