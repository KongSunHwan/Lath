package com.example.thishouse.domain.DTO;

import com.example.thishouse.domain.Notice;
import com.example.thishouse.domain.PageDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class WishDTO {
    private int house_num;
    private String house_type;
    private String deal_type;
    private int n_floors;
    private int m_cost;
    private String h_title;
    private int hits;
    private int exclusive_area2;
    private String save_name;
    private int deposit;
    private int m_price;
    private int y_price;
    private int total_m_cost;

    @Data
    @AllArgsConstructor
    public static class PageResponseList{
        private List<WishDTO> wishPageList;
        private PageDTO pageDTO;
    }

}
