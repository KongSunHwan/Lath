package com.example.thishouse.domain.contract;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contract {
    private int contract_idx;
    private int lessoer_idx;
    private int tenant_dix;
    private int house_num;

    private String contract_state;

    private String lease_term_begin;
    private String lease_term_end;
    private String contract_date;
    private String day_of_delivery;

    private String special_provisions;

    private long deposit;
    private long down_payment;
    private long middle_payment;
    private long balance;

    private String deal_type;

}
