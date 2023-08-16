package com.example.thishouse.mapper;

import com.example.thishouse.domain.house.*;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//interface사용시 오류 (required_bean error)
@Repository
@Mapper
@RequiredArgsConstructor
public class RealEstateMapper {
    private final SqlSessionTemplate sqlSession;
    private static final String Namespace = "com.example.thishouse.mapper.RealEstateMapper";

    public int sequence() {
        return sqlSession.selectOne(Namespace+".sequence");
    }

    public void insert_house_item(House_item houseItem) {
        sqlSession.insert(Namespace+".insert_house_item",houseItem);

    }

    public void insert_house_type(House_type houseType) {
        System.out.println("TEST CON MAPPER========");
        System.out.println(houseType.getHouse_type());
        System.out.println(houseType.getHouse_num());
        System.out.println(sqlSession.insert(Namespace+".insert_house_type", houseType));

        sqlSession.insert(Namespace+".insert_house_type", houseType);
    }

    public void insert_house_location(House_location houseLocation) {
        sqlSession.insert(Namespace+".insert_house_location",houseLocation);
    }

    public void insert_house_deal(House_deal houseDeal) {
        sqlSession.insert(Namespace+".insert_house_deal",houseDeal);
    }

    public void insert_house_info(House_info houseInfo) {
        sqlSession.insert(Namespace+".insert_house_info",houseInfo);
    }

    public void insert_house_addinfo(House_addinfo houseAddinfo) {
        sqlSession.insert(Namespace+".insert_house_addinfo",houseAddinfo);
    }

    public void insert_house_option(House_option houseOption) {
        sqlSession.insert(Namespace+".insert_house_option",houseOption);
    }

    public void insert_house_detail(House_detail houseDetail) {
        sqlSession.insert(Namespace+".insert_house_detail",houseDetail);
    }

    public void insert_picture(House_picture housePicture) {
        sqlSession.insert(Namespace+".insert_picture",housePicture);
    }

    public void insert_house_list(House_list houseList) {
        sqlSession.insert(Namespace+".insert_house_list",houseList);
    }

    public List<House_list> view_house_list_one(String house_num) {
        return sqlSession.selectList(Namespace+".view_house_list_one",house_num);
    }


    public void saveAll(List<House_picture> files) {
        sqlSession.insert(Namespace+".saveAll",files);
    }

    public List<House_list> view_house_list() {
        return sqlSession.selectList(Namespace+".view_house_list");
    }
    public List<House_picture> getHousePictures() {
        return sqlSession.selectList(Namespace+".getHousePictures");
    }


    public List<House_item> list_house_item(String house_num) {
        return sqlSession.selectList(Namespace+".list_house_item",house_num);
    }

    public List<House_addinfo> add_info_list(String houseNum) {
        return sqlSession.selectList(Namespace+".add_info_list",houseNum);
    }

    public List<House_detail> house_detail_list(String houseNum) {
        return sqlSession.selectList(Namespace+".house_detail_list",houseNum);
    }

    public List<House_option> house_option_list(String houseNum) {
        return sqlSession.selectList(Namespace+".house_option_list",houseNum);

    }

    public List<House_info> house_info_list(String houseNum) {
        return sqlSession.selectList(Namespace+".house_info_list",houseNum);

    }

    public List<House_type> house_type_list(String houseNum) {
        return sqlSession.selectList(Namespace+".house_type_list",houseNum);

    }

    public String road_address(String houseNum) {
        return sqlSession.selectOne(Namespace+".road_address",houseNum);
    }

    public List<House_picture> house_picture_list(String houseNum) {
        System.out.println("MAP PIC-----------------------");

        return sqlSession.selectList(Namespace+".house_picture_list",houseNum);
    }
}
