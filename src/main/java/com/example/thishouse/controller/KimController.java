package com.example.thishouse.controller;

import com.example.thishouse.domain.Inquire;
import com.example.thishouse.domain.community.Community;
import com.example.thishouse.domain.house.*;
import com.example.thishouse.service.MemberService;
import com.example.thishouse.service.RealEstateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class KimController {

    private final MemberService memberService;
    private final RealEstateService realEstateService;

    @RequestMapping("/test_inquire")
    public String test_my_community(String user_id, Model model) {
        List<Inquire> my_inquire = memberService.findInputMemberInquire(user_id);
        model.addAttribute("my_inquire",my_inquire);
        return "test_kim/test_inquire";
    }

    @RequestMapping("/test2_inquire")
    public String test2_inquire(String user_id, Model model) {
        List<Inquire> my_inquire = memberService.findInputMemberInquire(user_id);
        model.addAttribute("my_inquire",my_inquire);
        return "test_kim/test2_inquire";
    }

    @RequestMapping("/inquire_insert")
    public String inquire_insert(Inquire inquire, Model model) {
        memberService.inquire_insert(inquire);
        List<Inquire> my_inquire = memberService.findInputMemberInquire(inquire.getUser_id());
        model.addAttribute("my_inquire",my_inquire);
        return test2_inquire(inquire.getUser_id(),model);
    }

    @RequestMapping("/real_estate_insert")
    public String real_estate_insert(House_list house_list,House_addinfo house_addinfo, House_deal house_deal, House_detail house_detail, House_info house_info, House_item house_item,House_location house_location,House_option house_option,House_picture house_picture,House_type house_type, Model model) {

        System.out.println("Con");
        int sq = realEstateService.sequence();

        System.out.println("C = " + sq);
//
//        house_list.setHouse_num(sq);
//        house_addinfo.setHouse_num(sq);
//        house_deal.setHouse_num(sq);
//        house_detail.setHouse_num(sq);
//        house_info.setHouse_num(sq);
//        house_item.setHouse_num(sq);
//        house_location.setHouse_num(sq);
//        house_option.setHouse_num(sq);
//        house_picture.setHouse_num(sq);
//        house_type.setHouse_num(sq);

//        realEstateService.insert_house_item(house_item);
//        realEstateService.insert_house_type(house_type);
//        realEstateService.insert_house_location(house_location);
//        realEstateService.insert_house_deal(house_deal);
//        realEstateService.insert_house_info(house_info);
//        realEstateService.insert_house_addinfo(house_addinfo);
//        realEstateService.insert_house_option(house_option);
//        realEstateService.insert_house_detail(house_detail);
        //realEstateService.insert_picture(house_picture);
        //realEstateService.insert_house_list(house_list);

        return "main/main";
    }


}
