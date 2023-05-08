package com.example.thishouse.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class notice {
    private int notice_num;
    private String admin_id;
    private String notice_title;
    private String notice_content;
    private String notice_date;
}
