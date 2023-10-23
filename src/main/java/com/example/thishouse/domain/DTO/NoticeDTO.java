package com.example.thishouse.domain.DTO;

import com.example.thishouse.domain.Notice;
import com.example.thishouse.domain.PageDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class NoticeDTO {
    @Data
    @NoArgsConstructor
    public static class Response{
        private int notice_num;
        private String admin_id;
        private String notice_title;
        private String notice_content;
        private String notice_date;
        private int notice_hit;

        public Response(Notice notice) {
            this.notice_num= notice.getNotice_num();
            this.admin_id= notice.getAdmin_id();
            this.notice_title = notice.getNotice_title();
            this.notice_content = notice.getNotice_content();
            this.notice_date=notice.getNotice_date().format(DateTimeFormatter.ofPattern("yy-MM-dd HH:mm"));
            this.notice_hit= notice.getNotice_hit();
        }


        public static List<Response> ListNoticeToNoticeDto(List<Notice> notices){
            return notices.stream()
                    .map(notice -> new NoticeDTO.Response(notice)).collect(Collectors.toList());
        }

    }

    @Data
    @AllArgsConstructor
    public static class PageResponseList{
        private List<NoticeDTO.Response> noticePageList;
        private PageDTO pageDTO;
    }

}
