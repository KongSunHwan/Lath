package com.example.thishouse.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
public class Notice {
    private int notice_num;
    private String admin_id;
    private String notice_title;
    private String notice_content;
    private LocalDateTime notice_date;
    private int notice_hit;

    @Builder
    public Notice(int notice_num, String admin_id, String notice_title, String notice_content, LocalDateTime notice_date, int notice_hit) {
        this.notice_num = notice_num;
        this.admin_id = admin_id;
        this.notice_title = notice_title;
        this.notice_content = notice_content;
        this.notice_date = notice_date;
        this.notice_hit = notice_hit;
    }
}
