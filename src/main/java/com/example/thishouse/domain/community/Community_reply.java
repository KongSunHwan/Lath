package com.example.thishouse.domain.community;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Community_reply {
    private int reply_num;
    private int community_num;
    private String user_name;
    private String reply_contents;
    private Date reply_date;
}
