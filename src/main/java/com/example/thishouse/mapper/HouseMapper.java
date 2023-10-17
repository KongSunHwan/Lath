package com.example.thishouse.mapper;


import com.example.thishouse.domain.house.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface HouseMapper {
    public int sequence();

    public void insert_house_item(House_item houseItem);

    public void insert_house_type(House_type houseType);

    public void insert_house_location(House_location houseLocation);
    public void insert_house_deal(House_deal houseDeal);

    public void insert_house_info(House_info houseInfo);

    public void insert_house_addinfo(House_addinfo houseAddinfo);

    public void insert_house_option(House_option houseOption);

    public void insert_house_detail(House_detail houseDetail);
    public void insert_picture(House_picture housePicture);
    public void insert_house_list(House_list houseList);

    public List<House_list> view_house_list_one(String house_num);


    public void saveAll(List<House_picture> files);

    public List<HashMap> view_house_list();
    public List<House_picture> getHousePictures();


    public List<House_item> list_house_item(String house_num);

    public List<House_addinfo> add_info_list(String houseNum);

    public List<House_detail> house_detail_list(String houseNum);
    public List<House_option> house_option_list(String houseNum);

    public List<House_info> house_info_list(String houseNum);

    public List<House_type> house_type_list(String houseNum);
    public String road_address(String houseNum);

    public List<House_picture> house_picture_list(String houseNum);
    public List<HashMap> house_list_pg(House_list searchVO);
    public int house_list_pg_cnt();

    public List<HashMap> house_search_pg(House_list searchVO);

    public int house_search_pg_cnt(House_list searchVO);

    public void house_hit_coount(String houseNum);

    public String deal_type(String houseNum);

    public List<House_location> house_location(String houseNum);

    public String house_type(String houseNum);

    public int user_house_list_pg_cnt(String user_id);

    public List<HashMap> user_house_list_pg(House_list searchVO);

    HashMap get_house_info(String houseNum);

    List<HashMap> user_contract_request(List<String> houseNum);
}
