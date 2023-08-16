package com.example.thishouse.domain.house;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class House_list {
    private int house_list_num;
    private int house_num;
    private String house_thumb;
    private String house_type;
    private String road_address;
    private String deal_type;
    private int deposit;
    private int m_price;
    private int y_price;
    private String b_floors;
    private String n_floors;
    private String m_cost;
    private String m_cost_type;
    private String h_title;
    private int parkingfee;
    private int total_m_cost;
    private int hits;
    private float exclusive_area2;
    private List<MultipartFile> files = new ArrayList<>();    // 첨부파일 List
    private int approval;


}
