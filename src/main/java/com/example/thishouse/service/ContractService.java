package com.example.thishouse.service;

import com.example.thishouse.domain.contract.Contract;
import com.example.thishouse.domain.contract.Lessoer;
import com.example.thishouse.domain.contract.Tenant;
import com.example.thishouse.mapper.ContractMapper;
import com.example.thishouse.mapper.ReportMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ContractService {

    private final ContractMapper contractMapper;
    public void contract_request(Contract contract) {
        contractMapper.contract_request(contract);
    }

    public void tenant_info(Tenant tenant) {
        contractMapper.tenant_info(tenant);
    }


    @Transactional
    public void lessoer_info(Lessoer lessoer) {
        contractMapper.lessoer_info(lessoer);
    }
    //계약관련 테이블 전체
}
