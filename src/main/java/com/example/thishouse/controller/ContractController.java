package com.example.thishouse.controller;

import com.example.thishouse.domain.contract.Contract;
import com.example.thishouse.domain.contract.Tenant;
import com.example.thishouse.domain.house.House_info;
import com.example.thishouse.domain.house.House_location;
import com.example.thishouse.service.ContractService;
import com.example.thishouse.service.HouseService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ContractController {

    private final ContractService contractService;
    private final HouseService houseService;

    @RequestMapping("/contract_begin")
    public String contract_begin(Model model, String house_num, HttpSession session) {

        String house_deal_type = houseService.deal_type(house_num);
        List<House_location> house_location = houseService.house_location(house_num);
        String house_type = houseService.house_type(house_num);
        List<House_info> house_info = houseService.house_info_list(house_num);

        model.addAttribute("house_deal_type",house_deal_type);
        model.addAttribute("house_location",house_location);
        model.addAttribute("house_type",house_type);
        model.addAttribute("house_info",house_info);

        return "contract/real_estate_contract_test";
    }

    @PostMapping("/contract_request")
    public String contract_request(@Valid Contract contract, @Valid Tenant tenant, Model model, HttpSession session) {
        String user_id = (String) session.getAttribute("user_id"); //구매자
        tenant.setUser_id(user_id);
        contractService.tenant_info(tenant);
        int lessoer_num = contractService.get_lessoer(contract.getHouse_num());
        int tenant_num = contractService.get_tenant(contract.getHouse_num());
        contractService.contract_request(contract,lessoer_num,tenant_num);

        return "redirect:/contract_management";
    }

    @RequestMapping("/real_estate_contract")
    public String real_estate_contract() {
        return "contract/real_estate_contract";
    }


    @RequestMapping("/contract_Information_request")
    public String Contract_Information_request(HttpSession session, Model model) {
        String id = session.getAttribute("user_id").toString();
        List<Contract> list = contractService.getConList(id);
        model.addAttribute("contractList", list);
        return "contract/contract_Information_request";
    }

    @RequestMapping("/contract_Information_accept")
    public String Contract_Information_accept(HttpSession session, Model model) {
        String id = session.getAttribute("user_id").toString();
        List<Contract> list = contractService.getConList(id);
        model.addAttribute("contractList", list);
        return "contract/contract_Information_accept";
    }

    @RequestMapping("/contract_Information")
    public String Contract_Information(HttpSession session, Model model) {
        String id = session.getAttribute("user_id").toString();
        List<Contract> list = contractService.getConList(id);
        model.addAttribute("contractList", list);
        return "Contract_Information_request";
    }

    @GetMapping("/property_guide")
    public String property_guide() {
        return "guide/property_guide";
    }

    @GetMapping("/contract_management")
    public String contract_management() {
        return "contract/contract_management";
    }

    @GetMapping("/contract_deposit")
    public String contract_deposit() {
        return "contract/contract_deposit";
    }

    @GetMapping("/contract_progress")
    public String contract_progress() {
        return "contract/contract_progress";
    }

    //계약자 정보 기입창
    @RequestMapping("/real_estate_contract_test")
    public String real_estate_contract_test() {
        return "contract/real_estate_contract_test";
    }
}
