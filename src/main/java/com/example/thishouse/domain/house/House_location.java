package com.example.thishouse.domain.house;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class House_location {
    private int house_location_num;
    private int house_num;
    private String load_num;
    private String roadAddress;
    private String jibunAddress;
}
