package com.example.thishouse.controller;

import com.example.thishouse.domain.Report;
import com.example.thishouse.domain.contract.Lessoer;
import com.example.thishouse.domain.house.*;
import com.example.thishouse.service.ContractService;
import com.example.thishouse.service.HouseService;
import com.example.thishouse.service.MailService;
import com.example.thishouse.util.FileUpload;
import com.example.thishouse.util.PageCtrl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HouseController {

    private final HouseService houseService;
    private final ContractService contractService;

    public final String uploadPath = "C:/Timp/img/";

    @RequestMapping("/house_insert")
    public String real_estate_insert(House_list house_list,
                                     House_addinfo house_addinfo,
                                     House_deal house_deal,
                                     House_detail house_detail,
                                     House_info house_info,
                                     House_item house_item,
                                     House_location house_location,
                                     House_option house_option,
                                     House_picture house_picture,
                                     House_type house_type,
                                     Lessoer lessoer,
                                     HttpSession session,
                                     @RequestParam("files") List<MultipartFile> files) {

        int sq = houseService.sequence();
        house_list.setHouse_num(sq);
        house_addinfo.setHouse_num(sq);
        house_deal.setHouse_num(sq);
        house_detail.setHouse_num(sq);
        house_info.setHouse_num(sq);
        house_item.setHouse_num(sq);
        house_location.setHouse_num(sq);
        house_option.setHouse_num(sq);
        house_picture.setHouse_num(sq);
        house_type.setHouse_num(sq);
        lessoer.setHouse_num(sq);
        lessoer.setUser_id( (String) session.getAttribute("user_id"));
        List<String> filePaths = new ArrayList<>();

        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                try {
                    FileUpload fu = new FileUpload();
                    String originalFilename = file.getOriginalFilename();
                    String saveFilename = fu.generateSaveName(originalFilename);
                    String filePath = fu.uploadPath + saveFilename;
                    Path serverPath = Paths.get(uploadPath);
                    if (!Files.exists(serverPath)) {
                        Files.createDirectories(serverPath);
                    }
                    Files.write(Paths.get(filePath), file.getBytes());
                    filePaths.add(filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        for (int i = 0; i < filePaths.size(); i++) {
            FileUpload fu = new FileUpload();
            String filePath = filePaths.get(i);
            String originalFilename = files.get(i).getOriginalFilename();
            String saveFilename = fu.extractFileNameFromPath(filePath);
            house_picture.setFilePath(filePath);
            house_picture.setOriginal_name(originalFilename);
            house_picture.setSave_name(saveFilename);
            houseService.insert_picture(house_picture);
        }
        houseService.insert_house_item(house_item);
        houseService.insert_house_type(house_type);
        houseService.insert_house_location(house_location);
        houseService.insert_house_deal(house_deal);
        houseService.insert_house_info(house_info);
        houseService.insert_house_addinfo(house_addinfo);
        houseService.insert_house_option(house_option);
        houseService.insert_house_detail(house_detail);
        houseService.insert_house_list(house_list);
        contractService.lessoer_info(lessoer);

        return "redirect:/main";
    }

    @RequestMapping("/real_estate_detail")
    public String real_estate_detail(Model model, String house_num, HttpSession session) {
        System.out.println(house_num);
        List<House_list> house_list = houseService.view_house_list_one(house_num);
        List<House_item> house_item = houseService.list_house_item(house_num);
        List<House_addinfo> house_addinfo = houseService.add_info_list(house_num);
        List<House_detail> house_detail = houseService.house_detail_list(house_num);
        List<House_option> house_option = houseService.house_option_list(house_num);
        List<House_info> house_info = houseService.house_info_list(house_num);
        List<House_type> house_type = houseService.house_type_list(house_num);
        String road_address = houseService.road_address(house_num);
        List<House_picture> housePictures = houseService.house_picture_list(house_num);
        houseService.house_hit_coount(house_num);

        Report r = new Report();
        int house = Integer.parseInt(house_num);
        r.setHouse_num(house);

        model.addAttribute("house_list",house_list);
        model.addAttribute("house_item",house_item);
        model.addAttribute("house_addinfo",house_addinfo);
        model.addAttribute("house_detail",house_detail);
        model.addAttribute("house_option",house_option);
        model.addAttribute("house_info",house_info);
        model.addAttribute("house_type",house_type);
        model.addAttribute("road_address",road_address);
        model.addAttribute("housePictures",housePictures);
        model.addAttribute("report", r);
        model.addAttribute("house_num", house_num);

        return "house/house_detail";
    }

    @RequestMapping("/user_house_list")
    public String user_house_list(@ModelAttribute("searchVO") House_list searchVO, Model model, HttpSession session) {
        PageCtrl pagination  = new PageCtrl();
        pagination.setCurrentPageNo(searchVO.getPageIndex());
        pagination.setRecordCountPerPage(searchVO.getPageUnit_house());
        pagination.setPageSize(searchVO.getPageSize());

        searchVO.setFirstIndex(pagination.getFirstRecordIndex());
        searchVO.setRecordCountPerPage(pagination.getRecordCountPerPage());
        String user_id = (String) session.getAttribute("user_id");

        searchVO.setUser_id(user_id);

        List<HashMap> house_list = houseService.user_house_list_pg(searchVO);
        model.addAttribute("house_list" , house_list);
        int totCnt = houseService.user_house_list_pg_cnt(user_id);
        model.addAttribute("totCnt",totCnt);

        pagination.setTotalRecordCount(totCnt);
        searchVO.setEndDate(pagination.getLastPageNoOnPageList());
        searchVO.setStartDate(pagination.getFirstPageNoOnPageList());
        searchVO.setPrev(pagination.getXprev());
        searchVO.setNext(pagination.getXnext());
        model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)searchVO.getPageUnit()));
        model.addAttribute("pagination",pagination);
        return "user/user_house_list";
    }
}
