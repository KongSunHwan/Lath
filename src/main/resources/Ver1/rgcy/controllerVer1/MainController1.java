//package com.example.thishouse.controllerVer1;
//
//import com.example.thishouse.domain.house.House_list;
//import com.example.thishouse.service.MarkerService;
//import com.example.thishouse.service.MemberService;
//import com.example.thishouse.service.HouseService;
//import com.example.thishouse.service.ReportService;
//import com.example.thishouse.util.PageCtrl;
//import jakarta.servlet.http.HttpSession;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.List;
//
//@Controller
//@RequiredArgsConstructor
//public class MainController1 {
//
//    private final MemberService memberService;
//    private final HouseService houseService;
//    private final MarkerService markerService;
//    private final ReportService reportService;
////    @GetMapping("/map")
////    public String map(Model model) {
//////        List<MapVO> mapall = markerService.all_map();
////        List<HashMap> markers = markerService.getMarkers();
////        System.out.println("--------------------------------------");
////        System.out.println(markers.getClass());
////        System.out.println(markers.toString());
////        System.out.println("--------------------------------------");
////        model.addAttribute("markers", markers);
//////        model.addAttribute("mapall", mapall);
////
////        return "map/map";
////    }
////
////    @GetMapping("/map_test")
////    public String map_test(Model model, House_list houseList) {
////        System.out.println("맵테스트!!");
////        List<HashMap> markers = markerService.getMarkers();
////        model.addAttribute("markers", markers);
////        return "map/map_test";
////    }
////
////    @GetMapping("/map_filter")
////    public String map_fillter(Model model, House_list house_list) {
////        System.out.println("맵테스트!!");
////
////        List<HashMap> mapall = null;
////        List<HashMap> markers = null;
////
////        if(house_list.getHouse_type().equals("전체") && house_list.getDeal_type().equals("전체")){
////            System.out.println("모두 전체");
////            markers = markerService.getMarkers();
////            mapall=markerService.all_map();
////
////        }else if(house_list.getHouse_type().equals("전체")){
////            System.out.println("방 종류 전체");
////            markers = markerService.map_all_house_type_filter(house_list);
////        }else if( house_list.getDeal_type().equals("전체")){
////            System.out.println("거래 방법 전체");
////            markers = markerService.map_all_deal_type_filter(house_list);
////        }else{
////            System.out.println("모두 선택====================");
////            markers = markerService.map_filter(house_list);
////        }
////        model.addAttribute("markers", markers);
//////        model.addAttribute("mapall", mapall);
////
////        return "map/map";
////    }
//
//
//
//    @RequestMapping("/inquire")
//    public String inquire() {
//        return "inquire/inquire";
//    }
//
////    @GetMapping("/login")
////    public String login() {
////        return "userlog/login"; // 로그인되지 않은 상태
////    }
//
////    @PostMapping("/main/login")
////    public String login(Member member, HttpSession session, Model model) {
////
////        int ck = memberService.loginMember(member);
////        if (ck == 0) { // 로그인 실패
////            return "redirect:/login";
////
////        } else {
//////            session.setAttribute("user_id", member.getUser_id());
//////            return "main/main";
////             session.setAttribute("user_id", member.getUser_id());
////            List<HashMap> house_list = houseService.view_house_list();
////            model.addAttribute("house_list",house_list);
////            return "redirect:/index";
////        }
////    }
//
////    @RequestMapping("/logout")
////    public String logout(HttpSession session,Model model) {
////        session.invalidate();
////        return "redirect:/main";
////    }
//
////    @GetMapping("/signup")
////    public String signupForm(Model model) {
////        model.addAttribute("member", new Member());
////        return "userlog/signup";
////    }
//
////    @PostMapping("/signup")
////    public String signup(@Validated @ModelAttribute Member member,
////                         BindingResult bindingResult) {
////
////        //검증 실패
////        if (bindingResult.hasErrors()) {
////            return "userlog/signup";
////        }
////
////        memberService.sign_up(member);
////        return "redirect:/login";
////    }
//
////    @RequestMapping("idCk") // "idCk"라는 이름의 메서드는 HTTP 요청이 들어오면 실행
////    @ResponseBody //반환값은 숫자형태로, 클라이언트에서 받아서 처리할 수 있도록 해주는 "@ResponseBody" 어노테이션을 사용
////    public int idcheck(HttpServletRequest request, HttpServletResponse response, HttpSession session, String user_id) { // "id"라는 문자열 값을 매개변수로 받습니다.
////        int result = memberService.idCk(user_id); // 받은 "id" 값을 이용하여 "MemberService" 클래스에서 "idCk" 메서드를 호출하고, 그 결과를 반환합니다.
////        return result;
////    }
//
//    @RequestMapping("/steamed_list")
//    public String steamed_list() {
//        return "steamed/steamed_list";
//    }
//
////    @RequestMapping("/real_estate_add")
////    public String real_estate_add() {
////        return "real_estate_addasdfasdfasdf";
////    }
////    사용자 전용 세션처리
//
////    @RequestMapping("/real_estate_intro")
////    public String real_estate_intro(Model model) {
////        List<House_picture> housePictures = houseService.getHousePictures();
////        model.addAttribute("housePictures", housePictures);
////        return "real_estate/real_estate_intro";
////    }
//
////    @RequestMapping("/mypage")
////    public String mypage(String user_id, Model model) {
////        System.out.println("받아온 user_id 값 : " + user_id);
////        List<Community> comlist = memberService.my_community(user_id);
////        List<Report> replist = memberService.findInputMemberReport(user_id);
////        List<Inquire> inquireList = memberService.my_inquire_one(user_id);
////        int house_cnt = memberService.house_cnt(user_id);
////        int report_cnt = memberService.report_cnt(user_id);
//////        int contract_cnt = memberService.contract_cnt(user_id);
////
////        model.addAttribute("house_cnt", house_cnt);
////        model.addAttribute("report_cnt", report_cnt);
////        model.addAttribute("comlist", comlist);
////        model.addAttribute("replist", replist);
////        model.addAttribute("Member", memberService.findInputMember(user_id));
////        model.addAttribute("inquireList", inquireList);
////        return "user_mypage/mypage";
////    }
////
//    //회원 상세정보 조회
////    @RequestMapping("/FindInputMember")
////    public String getFindInputMember(String user_id, Model model) {
////        // 회원 정보를 model에 저장
////        model.addAttribute("Member", memberService.findInputMember(user_id));
////        System.out.println("클릭한 아이디 확인 : " + user_id);
////        return "user_mypage/find_input_member";
////    }
//
////    @RequestMapping("/user_house_list")
////    public String user_house_list(@ModelAttribute("searchVO") House_list searchVO, Model model, HttpSession session) {
////        PageCtrl pagination  = new PageCtrl();
////        pagination.setCurrentPageNo(searchVO.getPageIndex());
////        pagination.setRecordCountPerPage(searchVO.getPageUnit_house());
////        pagination.setPageSize(searchVO.getPageSize());
////
////        searchVO.setFirstIndex(pagination.getFirstRecordIndex());
////        searchVO.setRecordCountPerPage(pagination.getRecordCountPerPage());
////        String user_id = (String) session.getAttribute("user_id");
////
////        searchVO.setUser_id(user_id);
////
////        List<HashMap> house_list = houseService.user_house_list_pg(searchVO);
////        model.addAttribute("house_list" , house_list);
////        int totCnt = houseService.user_house_list_pg_cnt(user_id);
////        model.addAttribute("totCnt",totCnt);
////
////        pagination.setTotalRecordCount(totCnt);
////        searchVO.setEndDate(pagination.getLastPageNoOnPageList());
////        searchVO.setStartDate(pagination.getFirstPageNoOnPageList());
////        searchVO.setPrev(pagination.getXprev());
////        searchVO.setNext(pagination.getXnext());
////        model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)searchVO.getPageUnit()));
////        model.addAttribute("pagination",pagination);
////        return "user_mypage/user_house_list";
////    }
//
////    @RequestMapping("/user_report_list")
////    public String user_report_list(@ModelAttribute("searchVO") Report searchVO, Model model,HttpSession session) {
////        PageCtrl pagination  = new PageCtrl();
////        pagination.setCurrentPageNo(searchVO.getPageIndex());
////        pagination.setRecordCountPerPage(searchVO.getPageUnit_house());
////        pagination.setPageSize(searchVO.getPageSize());
////
////        searchVO.setFirstIndex(pagination.getFirstRecordIndex());
////        searchVO.setRecordCountPerPage(pagination.getRecordCountPerPage());
////        String user_id = (String) session.getAttribute("user_id");
////        searchVO.setUser_id(user_id);
////
////        List<Report> re_list = reportService.user_report(searchVO);
////        model.addAttribute("re_list" , re_list);
////        int totCnt = reportService.user_report_cnt(user_id);
////        model.addAttribute("totCnt",totCnt);
////        pagination.setTotalRecordCount(totCnt);
////        searchVO.setEndDate(pagination.getLastPageNoOnPageList());
////        searchVO.setStartDate(pagination.getFirstPageNoOnPageList());
////        searchVO.setPrev(pagination.getXprev());
////        searchVO.setNext(pagination.getXnext());
////        model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)searchVO.getPageUnit()));
////        model.addAttribute("pagination",pagination);
////
////        return "user_mypage/user_reportList";
////    }
//
////    @RequestMapping("/real_estate_contract")
////    public String real_estate_contract() {
////        return "contract/real_estate_contract";
////    }
////
////    @RequestMapping("/contract_Information")
////    public String Contract_Information() {
////        return "contract/Contract_Information";
////    }
////
////    @GetMapping("/property_guide")
////    public String property_guide() {
////        return "guide/property_guide";
////    }
////
////    @GetMapping("/contract_management")
////    public String contract_management() {
////        return "contract/contract_management";
////    }
////
////    @GetMapping("/contract_deposit")
////    public String contract_deposit() {
////        return "contract/contract_deposit";
////    }
////
////    @GetMapping("/contract_progress")
////    public String contract_progress() {
////        return "contract/contract_progress";
////    }
////
////    @GetMapping("/guide")
////    public String guide() {
////        return "guide/guide";
////    }
////
////    //계약자 정보 기입창
////    @RequestMapping("/real_estate_contract_test")
////    public String real_estate_contract_test() {
////        return "contract/real_estate_contract_test";
////    }
//
//}
