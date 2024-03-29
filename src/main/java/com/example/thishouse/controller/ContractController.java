package com.example.thishouse.controller;

import com.example.thishouse.domain.contract.Contract;
import com.example.thishouse.domain.contract.Lessoer;
import com.example.thishouse.domain.contract.Tenant;
import com.example.thishouse.domain.house.House_info;
import com.example.thishouse.domain.house.House_location;
import com.example.thishouse.service.ContractService;
import com.example.thishouse.service.HouseService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ContractController {

    private final ContractService contractService;
    private final HouseService houseService;

    @RequestMapping("/contract_begin")
    public String contract_begin(Model model, String house_num,HttpSession session) {
        String user_id = (String) session.getAttribute("user_id");

        if(contractService.exist_contract(house_num,user_id) >=1 ){
            return "redirect:/contract_Information_request";
        }

        String deal_type = houseService.deal_type(house_num);
        List<House_location> house_location = houseService.house_location(house_num);
        String house_type = houseService.house_type(house_num);
        List<House_info> house_info = houseService.house_info_list(house_num);

        model.addAttribute("deal_type",deal_type);
        model.addAttribute("house_location",house_location);
        model.addAttribute("house_type",house_type);
        model.addAttribute("house_info",house_info);

        return "contract/contract_write";
    }

    @PostMapping("/contract_request")
    public String contract_request(String house_num, @Valid Contract contract, @Valid Tenant tenant, HttpServletRequest request, HttpSession session) {
        String user_id = (String) session.getAttribute("user_id"); //구매자
        tenant.setUser_id(user_id);

        System.out.println(contract.getHouse_type() + contract.getDeal_type());

        contractService.tenant_info(tenant);
        int lessoer_num = contractService.get_lessoer(house_num);
        int tenant_num = contractService.get_tenant(user_id,house_num);
        contractService.contract_request(contract,lessoer_num,tenant_num);
        int contract_num = contractService.get_contract_id(lessoer_num,tenant_num,house_num);
        return "redirect:/contract_management?contract_idx="+contract_num;
    }

    @ResponseBody
    @PostMapping("/contract_state")
    public void contract_state(String contract_idx){
        contractService.state_update_request(contract_idx);
    }

    @RequestMapping("/real_estate_contract")
    public String real_estate_contract() {
        return "contract/real_estate_contract";
    }


    @RequestMapping("/contract_Information_request")
    public String Contract_Information_request(HttpSession session, Model model) {
        String id = session.getAttribute("user_id").toString();
        List<HashMap> list = contractService.getConReqList(id);
        model.addAttribute("contractList", list);
        return "contract/contract_Information_request";
    }

    @RequestMapping("/contract_Information_response")
    public String Contract_Information_accept(HttpSession session, Model model) {
        String id = session.getAttribute("user_id").toString();
        List<HashMap> list = contractService.getConResList(id);
        model.addAttribute("contractList", list);
        return "contract/contract_Information_response";
    }

    @RequestMapping("/contract_complete_process")
    public String contract_complete_process(String contract_idx) {
        houseService.approval_contract_complete(contract_idx);
        contractService.contract_complete(contract_idx);
        return "redirect:/contract_Information_response";
    }

    @RequestMapping("/contract_reject_process")
    public String contract_reject_process(String contract_idx) {
        contractService.contract_reject(contract_idx);
        return "redirect:/contract_Information_response";
    }

    @RequestMapping("/contract_complete_lessoer")
    public String contract_complete(HttpSession session, Model model) {
        String id = session.getAttribute("user_id").toString();
        List<HashMap> list = contractService.getCompleteList(id);
        model.addAttribute("contractList", list);
        return "contract/contract_complete_lessoer";
    }

    @RequestMapping("/contract_complete_tenant")
    public String contract_complete_tenant(HttpSession session, Model model) {
        String id = session.getAttribute("user_id").toString();
        List<HashMap> complete_tenant = contractService.get_complete_tenant(id);
        model.addAttribute("contractList", complete_tenant);
        return "contract/contract_complete_tenant";
    }

    @RequestMapping("/contract_Information")
    public String Contract_Information(HttpSession session, Model model) {
        return "contract/Contract_Information_request";
    }

    @GetMapping("/contract_management")
    public String contract_management(String contract_idx,Model model) {
        String house_num = contractService.get_house_num(contract_idx);
        HashMap house_info = houseService.get_house_info(house_num);

        model.addAttribute("contract_idx",contract_idx);
        model.addAttribute("house_info",house_info);

        return "contract/contract_management";
    }

    @GetMapping("/contract_detail")
    public String contract_detail(String contract_idx, Model model) {
        Contract contract =  contractService.getContractDetail(contract_idx);
        model.addAttribute("contract",contract);
        model.addAttribute("lessoer",contractService.getLessoerInfo(contract.getLessoer_idx()));
        model.addAttribute("tenant",contractService.getTenantInfo(contract.getTenant_idx()));
        return "contract/contract_detail";
    }

    @GetMapping("/contract_deposit")
    public String contract_deposit() {
        return "contract/contract_deposit";
    }

    @GetMapping("/contract_progress")
    public String contract_progress() {
        return "contract/contract_progress";
    }

}
