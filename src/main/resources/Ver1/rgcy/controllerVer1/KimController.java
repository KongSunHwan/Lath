//package com.example.thishouse.controllerVer1;
//
//import com.example.thishouse.domain.Inquire;
//import com.example.thishouse.domain.Report;
//import com.example.thishouse.domain.community.Community;
//import com.example.thishouse.domain.contract.Contract;
//import com.example.thishouse.domain.contract.Lessoer;
//import com.example.thishouse.domain.contract.Tenant;
//import com.example.thishouse.domain.house.*;
//import com.example.thishouse.service.*;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpSession;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.UrlResource;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.UUID;
//
//@Controller
//@RequiredArgsConstructor
//public class KimController {
//
//    private final MemberService memberService;
//    private final HouseService houseService;
//    private final ContractService contractService;
//    private final ReportService reportService;
//    private final String uploadPath = "C:/Timp/img/";
////    @RequestMapping("/test_inquire")
////    public String test_my_community(String user_id, Model model) {
////        List<Inquire> my_inquire = memberService.findInputMemberInquire(user_id);
////        model.addAttribute("my_inquire",my_inquire);
////        return "test_kim/test_inquire";
////    }
////
////    @RequestMapping("/test2_inquire")
////    public String test2_inquire(String user_id, Model model) {
////        List<Inquire> my_inquire = memberService.findInputMemberInquire(user_id);
////        model.addAttribute("my_inquire",my_inquire);
////        return "test_kim/test2_inquire";
////    }
////
////    @RequestMapping("/inquire_insert")
////    public String inquire_insert(Inquire inquire, Model model) {
////        System.out.println(inquire.getUser_id() + "CON INQ ===================");
////        memberService.inquire_insert(inquire);
////
////        List<Inquire> my_inquire = memberService.findInputMemberInquire(inquire.getUser_id());
////        model.addAttribute("my_inquire",my_inquire);
////        return test2_inquire(inquire.getUser_id(),model);
////    }
//
//
//
//    @RequestMapping("/real_estate_insert")
//    public String real_estate_insert(House_list house_list,
//                                     House_addinfo house_addinfo,
//                                     House_deal house_deal,
//                                     House_detail house_detail,
//                                     House_info house_info,
//                                     House_item house_item,
//                                     House_location house_location,
//                                     House_option house_option,
//                                     House_picture house_picture,
//                                     House_type house_type,
//                                     Lessoer lessoer,
//                                     HttpSession session,
//                                     @RequestParam("files") List<MultipartFile> files ,
//                                     HttpServletRequest request) {
//
//        System.out.println("Con");
//        int sq = houseService.sequence();
//
//        System.out.println("C = " + sq);
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
//        lessoer.setHouse_num(sq);
//
//        lessoer.setUser_id( (String) session.getAttribute("user_id"));
//
//        List<String> filePaths = new ArrayList<>();
//
//        for (MultipartFile file : files) {
//            if (!file.isEmpty()) {
//                try {
//                    // 업로드된 파일 정보 저장
//                    String originalFilename = file.getOriginalFilename();
//                    String saveFilename = generateSaveName(originalFilename);
//                    String filePath = uploadPath + saveFilename;
//
//                    // 파일 경로 수정 시작
//                    Path serverPath = Paths.get(uploadPath);
//                    if (!Files.exists(serverPath)) {
//                        Files.createDirectories(serverPath);
//                    }
//
//                    Files.write(Paths.get(filePath), file.getBytes());
//                    // 파일 경로 수정 끝
//
//                    filePaths.add(filePath);
//                    System.out.println("파일 경로: " + filePath);
//                    System.out.println("오리지널 파일 이름: " + originalFilename);
//                    System.out.println("저장 파일 이름: " + saveFilename);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        // 업로드된 파일 정보를 DB에 저장
//        for (int i = 0; i < filePaths.size(); i++) {
//            String filePath = filePaths.get(i);
//            String originalFilename = files.get(i).getOriginalFilename();
//
//            // 파일 이름만 추출하여 저장
//            String saveFilename = extractFileNameFromPath(filePath);
//
//            house_picture.setFilePath(filePath);
//            house_picture.setOriginal_name(originalFilename);
//            house_picture.setSave_name(saveFilename);
//
//            houseService.insert_picture(house_picture);
//
//            System.out.println("파일 경로를 활용한 처리: " + filePath);
//        }
//
//        houseService.insert_house_item(house_item);
//        houseService.insert_house_type(house_type);
//        houseService.insert_house_location(house_location);
//        houseService.insert_house_deal(house_deal);
//        houseService.insert_house_info(house_info);
//        houseService.insert_house_addinfo(house_addinfo);
//        houseService.insert_house_option(house_option);
//        houseService.insert_house_detail(house_detail);
//        houseService.insert_house_list(house_list);
//        contractService.lessoer_info(lessoer);
//
//        return "redirect:/main";
//    }
//
//    @RequestMapping("/pic_test")
//    public String pic_test() {
//        return "test_kim/pic_test";
//    }
//
//    @RequestMapping("/real_estate_detail")
//    public String real_estate_detail(Model model, String house_num, HttpSession session) {
//        System.out.println(house_num);
//        List<House_list> house_list = houseService.view_house_list_one(house_num);
//        List<House_item> house_item = houseService.list_house_item(house_num);
//        List<House_addinfo> house_addinfo = houseService.add_info_list(house_num);
//        List<House_detail> house_detail = houseService.house_detail_list(house_num);
//        List<House_option> house_option = houseService.house_option_list(house_num);
//        List<House_info> house_info = houseService.house_info_list(house_num);
//        List<House_type> house_type = houseService.house_type_list(house_num);
//        String road_address = houseService.road_address(house_num);
//        List<House_picture> housePictures = houseService.house_picture_list(house_num);
//
//        houseService.house_hit_coount(house_num);
//
//        Report r = new Report();
//        int house = Integer.parseInt(house_num);
//        r.setHouse_num(house);
//
//        model.addAttribute("house_list",house_list);
//        model.addAttribute("house_item",house_item);
//        model.addAttribute("house_addinfo",house_addinfo);
//        model.addAttribute("house_detail",house_detail);
//        model.addAttribute("house_option",house_option);
//        model.addAttribute("house_info",house_info);
//        model.addAttribute("house_type",house_type);
//        model.addAttribute("road_address",road_address);
//        model.addAttribute("housePictures",housePictures);
//        model.addAttribute("report", r);
//        model.addAttribute("house_num", house_num);
//
//        return "test_kim/real_estate_detail";
//    }
//
////    @RequestMapping("/contract_begin")
////    public String contract_begin(Model model, String house_num, HttpSession session) {
////
////        String house_deal_type = houseService.deal_type(house_num);
////        List<House_location> house_location = houseService.house_location(house_num);
////        String house_type = houseService.house_type(house_num);
////        List<House_info> house_info = houseService.house_info_list(house_num);
////
////        model.addAttribute("house_deal_type",house_deal_type);
////        model.addAttribute("house_location",house_location);
////        model.addAttribute("house_type",house_type);
////        model.addAttribute("house_info",house_info);
////
////        return "contract/real_estate_contract_test";
////    }
////
////    @RequestMapping("/contract_request")
////    public String contract_request(@Valid Contract contract, @Valid Tenant tenant, Model model, HttpSession session) {
////        String user_id = (String) session.getAttribute("user_id"); //구매자
////        tenant.setUser_id(user_id);
////        contractService.tenant_info(tenant);
////        int tenant_num = contractService.get_tenant(contract.getHouse_num());
////        System.out.println(contract.getHouse_num()  + "asdf"+ tenant_num + "TEST1==================================");
////        int lessoer_num = contractService.get_lessoer(contract.getHouse_num());
////        System.out.println(lessoer_num+"TEST2==================================");
////        contractService.contract_request(contract,lessoer_num,tenant_num);
////        System.out.println("TEST3==================================");
////
////        return "redirect:/contract_management";
////    }
//
//
//
////    @RequestMapping("/file_upload")
////    public String file_upload(House_picture house_picture,Model model) {
////        List<House_picture> files = File_util.uploadFiles(house_picture.getFiles());
////        realEstateService.saveFiles(house_picture.getHouse_num(), files);
////        realEstateService.insert_picture(house_picture);
////        return "test_kim/file_upload";
////    }
//
//    private String generateSaveName(String original_name) {
//        String uuid = UUID.randomUUID().toString();
//        String extension = original_name.substring(original_name.lastIndexOf("."));
//        String saveName = uuid + extension;
//
//        // 파일명 중복 방지를 위해 파일명에 UUID 추가
//        String filePath = uploadPath + saveName;
//        while (Files.exists(Paths.get(filePath))) {
//            uuid = UUID.randomUUID().toString();
//            saveName = uuid + extension;
//            filePath = uploadPath + saveName;
//        }
//
//        return saveName;
//    }
//    // 저장 파일명 생성
//    private String extractFileNameFromPath(String filePath) {
//        File file = new File(filePath);
//        return file.getName();
//    }
//
////    @RequestMapping("/my_board_list")
////    public String my_board_list(Model model, String user_id) {
////        List<Community> my_board = memberService.my_board_list(user_id);
////        model.addAttribute("my_board",my_board);
////
////        return "test_kim/my_board_list";
////    }
//
//    // 이미지 파일 전송
//    @ResponseBody
//    @GetMapping("/images/{filename}")
//    public Resource downloadImage(@PathVariable String filename) throws MalformedURLException {
//        return new UrlResource("file:" + uploadPath + filename);
//    }
//
////    @PostMapping("/report_insert")
////    public String report_insert(@Valid Report report, BindingResult bindingResult,
////                                @RequestParam("report_content_pic") MultipartFile report_content_pic,
////                                @RequestParam("report_seller_pic") MultipartFile report_seller_pic,
////                                @RequestParam("report_house_pic") MultipartFile report_house_pic,
////                                Model model,
////                                HttpSession session) {
////
////
////        System.out.println(report.getHouse_num() + "집번호");
////
////        // 파일 업로드 및 처리 로직을 추상화한 메서드를 사용합니다.
////        processFile(report_content_pic, "report_content_pic", report);
////        processFile(report_seller_pic, "report_seller_pic", report);
////        processFile(report_house_pic, "report_house_pic", report);
////
////        String user_id = (String) session.getAttribute("user_id");
////        report.setUser_id(user_id);
////        System.out.println(report.getHouse_num() + "================");
////        reportService.insertReport(report);
////
////        return "redirect:/main";
////    }
//
//
//    // 파일 업로드 및 처리 로직을 추상화한 메서드
//    private void processFile(MultipartFile file, String fieldName, Report report) {
//        if (!file.isEmpty()) {
//            try {
//                byte[] fileBytes = file.getBytes();
//
//                String fileName = fieldName + "_" + UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
//                System.out.println("업로드된 파일 이름: " + fileName); // 파일 이름 출력
//
//                Path filePath = Paths.get(uploadPath + fileName);
//                Files.write(filePath, fileBytes);
//
//                if (fieldName.equals("report_content_pic")) {
//                    report.setReport_content_pic(fileName);
//                } else if (fieldName.equals("report_seller_pic")) {
//                    report.setReport_seller_pic(fileName);
//                } else if (fieldName.equals("report_house_pic")) {
//                    report.setReport_house_pic(fileName);
//                }
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//}
