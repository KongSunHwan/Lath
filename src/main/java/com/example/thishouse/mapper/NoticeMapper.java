package com.example.thishouse.mapper;


import com.example.thishouse.domain.Criteria;
import com.example.thishouse.domain.Notice;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface NoticeMapper {
    public List<Notice> notice_list();
    //공지사항 페이징 리스트
    public List<Notice> pg_list(Notice searchVO);

    public int pg_listCnt();

    //공지사항 상세보기
    public Notice view_notice(String notice_num);

    public void update_notice_hitCount(String noticeNum);

    public void insert_notice(Notice notice);

    public void update_notice(Notice notice);

    public void delete_notice(String noticeNum);

    public List<Notice> pg_list_search(Notice searchVO);

    public int pg_list_searchcnt(Notice searchVO);

    List<Notice> findList(Criteria criteria);

    int findCount(Criteria criteria);
}
