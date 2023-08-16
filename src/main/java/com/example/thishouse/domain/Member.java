package com.example.thishouse.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member extends PageVO{
    private int user_num;
    private String user_id;
    private String user_pw;
    private String user_name;
    private String user_phone;
    private String user_create_time;

    private String search_name;
    private String search_content;
}
