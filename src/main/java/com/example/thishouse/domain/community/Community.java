package com.example.thishouse.domain.community;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Community {
    private int community_num;
    private String community_title;
    private String user_id;
    private String community_contents;
    private String community_date;
    private int community_hits;
}
