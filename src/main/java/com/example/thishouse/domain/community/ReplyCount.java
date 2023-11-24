package com.example.thishouse.domain.community;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReplyCount {
    private int community_num;
    private int replyCount;
}
