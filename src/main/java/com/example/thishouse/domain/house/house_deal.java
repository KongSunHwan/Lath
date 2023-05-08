package com.example.thishouse.domain.house;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class house_deal {
    private int house_num;
    private String deal_type;
    private int deposit;
    private int monthly_rent;
    private int charter_price;
}
