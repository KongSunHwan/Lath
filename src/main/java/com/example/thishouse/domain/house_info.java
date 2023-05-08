package com.example.thishouse.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class house_info {
    private int house_num;
    private int supply_area1;
    private int supply_area2;
    private int exclusive_area1;
    private int exclusive_area2;
    private int b_floors;
    private int n_floors;
    private String heating_type;
    private String move_in_date;

}
