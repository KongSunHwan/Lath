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
    private String house_thum;
    private String s_type;
    private String b_type;
    private String address;
    private String deal_type;
    private int deposit;
    private int monthly_rent;
    private int charter_price;
    private String b_floors;
    private String n_floors;
    private int m_cost;
    private String m_costx;
    private String h_title;
}
