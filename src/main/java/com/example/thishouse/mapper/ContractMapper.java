package com.example.thishouse.mapper;

import com.example.thishouse.domain.contract.Contract;
import com.example.thishouse.domain.contract.Lessoer;
import com.example.thishouse.domain.contract.Tenant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ContractMapper {
    void contract_request(Contract contract);

    void tenant_info(Tenant tenant);

    void lessoer_info(Lessoer lessoer);

    int get_lessoer(String houseNum);

    int get_tenant(@Param("user_id") String user_id,@Param("house_num") String house_num);

    List<HashMap> getConReqList(String id);

    String get_tenant_id(String userId);

    String get_lessoer_id(String userId);

    int get_contract_request(String tenant);

    int get_contract_accept(String user_id);

    int get_contract_id(@Param("lessoer_idx") int lessoerNum,@Param("tenant_idx") int tenantNum,@Param("house_num") String houseNum);

    String get_house_num(String contractIdx);

    List<HashMap> getConResList(String id);

    int exist_contract(@Param("house_num") String house_num,@Param("user_id") String user_id);

    void state_update_request(String contractIdx);

    List<HashMap> getCompleteList(String id);

    int contract_complete_cnt(String id);

    int contract_complete_cnt_tenant(String id);

    List<HashMap> get_complete_tenant(String id);

    void contract_complete(String contract_idx);

    String getLessoerIdByContractIdx(String contractIdx);

    String getTenantIdByContractIdx(String contractIdx);


    void delete_contarct(String contractIdx);

    void delete_lessoer(String lessoerIdx);

    void delete_tenant(String tenantIdx);

    void contract_reject(String contractIdx);

    void reject_same_house_contract(String houseNum);
}
