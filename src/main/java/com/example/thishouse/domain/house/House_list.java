package com.example.thishouse.domain.house;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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


}
