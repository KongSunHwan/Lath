package com.example.thishouse.controller;

import com.example.thishouse.domain.Inquire;
import com.example.thishouse.domain.Report;
import com.example.thishouse.domain.community.Community;
import com.example.thishouse.domain.house.*;
import com.example.thishouse.service.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class KimController {

    private final MemberService memberService;
    private final RealEstateService realEstateService;
    private final BoardService boardService;
    private final MarkerService markerService;
    private final ReportService reportService;
    private final String uploadPath = "C:/Timp/img/";
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
        System.out.println(inquire.getUser_id() + "CON INQ ===================");
        memberService.inquire_insert(inquire);

        List<Inquire> my_inquire = memberService.findInputMemberInquire(inquire.getUser_id());
        model.addAttribute("my_inquire",my_inquire);
        return test2_inquire(inquire.getUser_id(),model);
    }



    @RequestMapping("/real_estate_insert")
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
                                     Model model,
                                     @RequestParam("files") List<MultipartFile> files ,
                                     HttpServletRequest request) {

        System.out.println("Con");
        int sq = realEstateService.sequence();

        System.out.println("C = " + sq);

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

        List<String> filePaths = new ArrayList<>();

        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                try {
                    // 업로드된 파일 정보 저장
                    String originalFilename = file.getOriginalFilename();
                    String saveFilename = generateSaveName(originalFilename);
                    String filePath = uploadPath + saveFilename;

                    // 파일 경로 수정 시작
                    Path serverPath = Paths.get(uploadPath);
                    if (!Files.exists(serverPath)) {
                        Files.createDirectories(serverPath);
                    }

                    Files.write(Paths.get(filePath), file.getBytes());
                    // 파일 경로 수정 끝

                    filePaths.add(filePath);
                    System.out.println("파일 경로: " + filePath);
                    System.out.println("오리지널 파일 이름: " + originalFilename);
                    System.out.println("저장 파일 이름: " + saveFilename);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // 업로드된 파일 정보를 DB에 저장
        for (int i = 0; i < filePaths.size(); i++) {
            String filePath = filePaths.get(i);
            String originalFilename = files.get(i).getOriginalFilename();

            // 파일 이름만 추출하여 저장
            String saveFilename = extractFileNameFromPath(filePath);

            house_picture.setFilePath(filePath);
            house_picture.setOriginal_name(originalFilename);
            house_picture.setSave_name(saveFilename);

            realEstateService.insert_picture(house_picture);

            System.out.println("파일 경로를 활용한 처리: " + filePath);
        }

        realEstateService.insert_house_item(house_item);
        realEstateService.insert_house_type(house_type);
        realEstateService.insert_house_location(house_location);
        realEstateService.insert_house_deal(house_deal);
        realEstateService.insert_house_info(house_info);
        realEstateService.insert_house_addinfo(house_addinfo);
        realEstateService.insert_house_option(house_option);
        realEstateService.insert_house_detail(house_detail);
        realEstateService.insert_house_list(house_list);

        return "redirect:/list_main";
    }

    @RequestMapping("/pic_test")
    public String pic_test() {
        return "test_kim/pic_test";
    }

    @RequestMapping("/list_search")
    public String list_search(@ModelAttribute("searchVO") House_list searchVO,  Model model) {
//        List<House_list> house_list = realEstateService.view_house_list();
//        model.addAttribute("house_list",house_list);
//
//        PageCtrl pagination  = new PageCtrl();
//        pagination.setCurrentPageNo(searchVO.getPageIndex());
//        pagination.setRecordCountPerPage(searchVO.getPageUnit_house());
//        pagination.setPageSize(searchVO.getPageSize());
//
//        searchVO.setFirstIndex(pagination.getFirstRecordIndex());
//        searchVO.setRecordCountPerPage(pagination.getRecordCountPerPage());
//        System.out.println("펄스트인덱스 : " + searchVO.getFirstIndex());
//
//        List<House_list> house_list = realEstateService.house_list_pg(searchVO);
//        model.addAttribute("house_list" , house_list);
//        int totCnt = realEstateService.house_list_pg_cnt();
//        model.addAttribute("totCnt",totCnt);
//        System.out.println("전체 매물 수 : " + totCnt);
//
//        pagination.setTotalRecordCount(totCnt);
//
//        searchVO.setEndDate(pagination.getLastPageNoOnPageList());
//        searchVO.setStartDate(pagination.getFirstPageNoOnPageList());
//        searchVO.setPrev(pagination.getXprev());
//        searchVO.setNext(pagination.getXnext());
//        model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)searchVO.getPageUnit()));
//        model.addAttribute("pagination",pagination);

        return "test_kim/main_RE_list";
    }

    @RequestMapping("/list_main")
    public String list_main(@ModelAttribute("searchVO") House_list searchVO, HttpServletRequest request, Model model) {
//        List<House_list> house_list = realEstateService.view_house_list();
//        model.addAttribute("house_list",house_list);

//        PageCtrl pagination  = new PageCtrl();
//        pagination.setCurrentPageNo(searchVO.getPageIndex());
//        pagination.setRecordCountPerPage(searchVO.getPageUnit_house());
//        pagination.setPageSize(searchVO.getPageSize());
//
//        searchVO.setFirstIndex(pagination.getFirstRecordIndex());
//        searchVO.setRecordCountPerPage(pagination.getRecordCountPerPage());
//        System.out.println("펄스트인덱스 : " + searchVO.getFirstIndex());
//
//        List<House_list> house_list = realEstateService.house_list_search(searchVO);
//        model.addAttribute("house_list" , house_list);
//        int totCnt = realEstateService.house_list_search_cnt();
//        model.addAttribute("totCnt",totCnt);
//        System.out.println("검색 매물 수 : " + totCnt);
//
//        pagination.setTotalRecordCount(totCnt);
//
//        searchVO.setEndDate(pagination.getLastPageNoOnPageList());
//        searchVO.setStartDate(pagination.getFirstPageNoOnPageList());
//        searchVO.setPrev(pagination.getXprev());
//        searchVO.setNext(pagination.getXnext());
//        model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)searchVO.getPageUnit()));
//        model.addAttribute("pagination",pagination);

        return "test_kim/main_RE_list";
    }

    @RequestMapping("/real_estate_detail")
    public String real_estate_detail(Model model, String house_num) {
        System.out.println(house_num);
        List<House_list> house_list = realEstateService.view_house_list_one(house_num);
        List<House_item> house_item = realEstateService.list_house_item(house_num);
        List<House_addinfo> house_addinfo = realEstateService.add_info_list(house_num);
        List<House_detail> house_detail = realEstateService.house_detail_list(house_num);
        List<House_option> house_option = realEstateService.house_option_list(house_num);
        List<House_info> house_info = realEstateService.house_info_list(house_num);
        List<House_type> house_type = realEstateService.house_type_list(house_num);
        String road_address = realEstateService.road_address(house_num);
        List<House_picture> housePictures = realEstateService.house_picture_list(house_num);


        model.addAttribute("house_list",house_list);
        model.addAttribute("house_item",house_item);
        model.addAttribute("house_addinfo",house_addinfo);
        model.addAttribute("house_detail",house_detail);
        model.addAttribute("house_option",house_option);
        model.addAttribute("house_info",house_info);
        model.addAttribute("house_type",house_type);
        model.addAttribute("road_address",road_address);
        model.addAttribute("housePictures",housePictures);
        model.addAttribute("report", new Report()); // Report 클래스의 인스턴스 생성

        return "test_kim/real_estate_detail";
    }


//    @RequestMapping("/file_upload")
//    public String file_upload(House_picture house_picture,Model model) {
//        List<House_picture> files = File_util.uploadFiles(house_picture.getFiles());
//        realEstateService.saveFiles(house_picture.getHouse_num(), files);
//        realEstateService.insert_picture(house_picture);
//        return "test_kim/file_upload";
//    }

    private String generateSaveName(String original_name) {
        String uuid = UUID.randomUUID().toString();
        String extension = original_name.substring(original_name.lastIndexOf("."));
        String saveName = uuid + extension;

        // 파일명 중복 방지를 위해 파일명에 UUID 추가
        String filePath = uploadPath + saveName;
        while (Files.exists(Paths.get(filePath))) {
            uuid = UUID.randomUUID().toString();
            saveName = uuid + extension;
            filePath = uploadPath + saveName;
        }

        return saveName;
    }
    // 저장 파일명 생성
    private String extractFileNameFromPath(String filePath) {
        File file = new File(filePath);
        return file.getName();
    }

    @RequestMapping("/my_board_list")
    public String my_board_list(Model model, String user_id) {
        List<Community> my_board = memberService.my_board_list(user_id);
        return "test_kim/my_board_list";
    }

    // 이미지 파일 전송
    @ResponseBody
    @GetMapping("/images/{filename}")
    public Resource downloadImage(@PathVariable String filename) throws MalformedURLException {
        return new UrlResource("file:" + uploadPath + filename);
    }

    @PostMapping("/report_insert")
    public String report_insert(Report report1, Model model) {
        // 수정된 Report 객체를 다시 데이터베이스에 저장
        reportService.insertReport(report1);
        return "redirect:/list_main";
    }

}
