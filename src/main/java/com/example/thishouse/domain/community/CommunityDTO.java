package com.example.thishouse.domain.community;

import com.example.thishouse.domain.PageDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommunityDTO {
        private int community_num;
        private String community_title;
        private String user_id;
        private String community_contents;
        private String community_date;
        private int community_hits;
        private int replyCount;

    @Data
    @AllArgsConstructor
    public static class PageResponseList{
        private List<CommunityDTO> communityPageList;
        private PageDTO pageDTO;
    }
}
