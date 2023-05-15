package com.example.thishouse.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    private int report_num;
    private int house_num;
    private String user_id;
    private String report_title;
    private String report_content;
    private String report_pic;
}
