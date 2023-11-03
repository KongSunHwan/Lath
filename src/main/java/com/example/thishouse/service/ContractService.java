package com.example.thishouse.service;

import com.example.thishouse.domain.contract.Contract;
import com.example.thishouse.domain.contract.Lessoer;
import com.example.thishouse.domain.contract.Tenant;
import com.example.thishouse.mapper.ContractMapper;
import com.example.thishouse.mapper.HouseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ContractService {

    private final ContractMapper contractMapper;

    @Transactional
    public void contract_request(Contract contract, int lessoer_num,int tenant_num) {
        contract.setTenant_idx(tenant_num);
        contract.setLessoer_idx(lessoer_num);
        contractMapper.contract_request(contract);
    }

    @Transactional
    public void tenant_info(Tenant tenant) {
        contractMapper.tenant_info(tenant);
    }

    @Transactional
    public void lessoer_info(Lessoer lessoer) {
        contractMapper.lessoer_info(lessoer);
    }


    public int get_lessoer(String houseNum) {
        return contractMapper.get_lessoer(houseNum);
    }


    public int get_tenant(String user_id,String house_num) {
        return contractMapper.get_tenant(user_id,house_num);
    }

    public List<HashMap> getConReqList(String id){
        return contractMapper.getConReqList(id);
    }

    public int get_contract_request(String user_id) {
        return contractMapper.get_contract_request(user_id);
    }

    public int get_contract_accept(String user_id) {
        return contractMapper.get_contract_accept(user_id);
    }


    public int get_contract_id(int lessoerNum, int tenantNum,String house_num) {
        return contractMapper.get_contract_id(lessoerNum,tenantNum,house_num);
    }

    public String get_house_num(String contractIdx) {
        return contractMapper.get_house_num(contractIdx);
    }

    public List<HashMap> getConResList(String id) {
        return contractMapper.getConResList(id);
    }

    public int exist_contract(String house_num,String userId) {
        return contractMapper.exist_contract(house_num,userId);
    }

    @Transactional
    public void state_update_request(String contractIdx) {
        contractMapper.state_update_request(contractIdx);

    }

    public List<HashMap> getCompleteList(String id) {
        return contractMapper.getCompleteList(id);
    }
}
