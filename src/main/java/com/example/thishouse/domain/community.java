package com.example.thishouse.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class community {
    private int community_num;
    private String community_title;
    private String user_name;
    private String community_contents;
    private String community_date;
    private String community_replynum;
    private String community_hits;
}
