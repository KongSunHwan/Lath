package com.example.thishouse.util;

import lombok.Data;

@Data
public class Criteria {
    private int pageNum;
    private int amount;
    private int skip;
    private String type;
    private String keyword;

    public Criteria(){
        this(1,10);
    }

    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
        this.skip = (pageNum-1) * amount;  //1 -1 = 0 * 10 = pageNum은 0 , amount 10 0번째부터 10번째까지
}

    public Criteria(int pageNum, int amount, String type, String keyword){
        this.pageNum = pageNum;
        this.amount = amount;
        this.skip = (pageNum-1) * amount;
        this.type = type;
        this.keyword = keyword;
    }

    public String[] getTypeArr(){
        return type == null? new String[]{}:type.split("");
    }
}
