package com.example.thishouse.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class house_addinfo {
    private int house_num;
    private int m_cost;
    private String m_ok;
    private String m_costx;
    private String m_internet;
    private String m_wiredtv;
    private String m_cleaning;
    private String m_watertax;
    private String m_citygas;
    private String m_elec;
    private String m_etc;
    private String elevator;
    private String v_b;
    private String parking;
    private String parkingfee;
    private String bulit_in;
    private String structure;
}
