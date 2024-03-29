package com.example.thishouse.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageVO {
    private int pageIndex = 1;				    //현재페이지
    private int pageUnit = 10;				    //페이지갯수
    private int pageSize = 10;	    			//페이지사이즈
    private int firstIndex = 1;		    		//firstIndex
    private int recordCountPerPage = 10;		//recordCountPerPage
    private int totCnt = 0;				      	//총갯수
    private int startDate = 0;			    	//시작데이터
    private int endDate = 0;				    //종료데이터
    private int realEnd = 0;				    //페이징 마지막 숫자
    private int pageUnit_house = 6;				//메인용페이지갯수
    private boolean prev, next;	    			//이전,다음버튼


    //getter&setter
    public int getPageIndex() {
        return pageIndex;
    }
    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageUnit() {
        return pageUnit;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getFirstIndex() {
        return firstIndex;
    }

    public void setFirstIndex(int firstIndex) {
        this.firstIndex = firstIndex;
    }

    public void setRecordCountPerPage(int recordCountPerPage) {
        this.recordCountPerPage = recordCountPerPage;
    }

    public boolean isPrev() {
        return prev;
    }

    public void setPrev(boolean prev) {
        this.prev = prev;
    }

    public boolean isNext() {
        return next;
    }

    public void setNext(boolean next) {
        this.next = next;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

}
