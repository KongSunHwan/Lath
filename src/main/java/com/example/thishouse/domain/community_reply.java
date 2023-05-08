package com.example.thishouse.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class community_reply {
    private int reply_num;
    private int community_num;
    private String user_name;
    private String reply_contents;
    private int reply_level;
    private Date reply_date;
}
