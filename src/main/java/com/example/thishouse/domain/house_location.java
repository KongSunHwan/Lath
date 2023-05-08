package com.example.thishouse.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class house_location {
    private int house_num;
    private String roadAddress;
    private String jibunAddress;
}
