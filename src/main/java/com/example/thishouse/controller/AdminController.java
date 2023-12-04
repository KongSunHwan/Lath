package com.example.thishouse.controller;

import com.example.thishouse.domain.Criteria;
import com.example.thishouse.domain.DTO.NoticeDTO;
import com.example.thishouse.domain.DTO.ResponsePageDTO;
import com.example.thishouse.domain.Member;
import com.example.thishouse.domain.Notice;
import com.example.thishouse.domain.Report;
import com.example.thishouse.domain.community.Community;
import com.example.thishouse.domain.community.Community_reply;
import com.example.thishouse.domain.contract.Contract;
import com.example.thishouse.domain.house.*;
import com.example.thishouse.service.*;
import com.example.thishouse.util.PageCtrl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final CommunityService communityService;
    private final AdminService adminService;
    private final NoticeService noticeService;
    private final HouseService houseService;
    private final ReportService reportService;
    private final ContractService contractService;
    @GetMapping("admin/member")
    public String Members_Search(@ModelAttribute("searchVO") Member searchVO, HttpServletRequest request, Model model) {
        PageCtrl pagination  = new PageCtrl();
        pagination.setCurrentPageNo(searchVO.getPageIndex());
        pagination.setRecordCountPerPage(searchVO.getPageUnit());
        pagination.setPageSize(searchVO.getPageSize());
        searchVO.setFirstIndex(pagination.getFirstRecordIndex());
        searchVO.setRecordCountPerPage(pagination.getRecordCountPerPage());
        String context = request.getParameter("searchValue");

        if(context == null){
            List<Member> memberList = adminService.memberAll(searchVO);
            model.addAttribute("memberList" , memberList);
            int totCnt = adminService.memberList_cnt();
            model.addAttribute("totCnt",totCnt);
            pagination.setTotalRecordCount(totCnt);
            searchVO.setEndDate(pagination.getLastPageNoOnPageList());
            searchVO.setStartDate(pagination.getFirstPageNoOnPageList());
            searchVO.setPrev(pagination.getXprev());
            searchVO.setNext(pagination.getXnext());
            model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)searchVO.getPageUnit()));
            model.addAttribute("pagination",pagination);
        }
        else if(context != null && context == ""){
            List<Member> memberList = adminService.memberAll(searchVO);
            model.addAttribute("memberList" , memberList);
            int totCnt = adminService.memberList_cnt();
            model.addAttribute("totCnt",totCnt);
            pagination.setTotalRecordCount(totCnt);
            searchVO.setEndDate(pagination.getLastPageNoOnPageList());
            searchVO.setStartDate(pagination.getFirstPageNoOnPageList());
            searchVO.setPrev(pagination.getXprev());
            searchVO.setNext(pagination.getXnext());
            model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)searchVO.getPageUnit()));
            model.addAttribute("pagination",pagination);
        }
        else{
            searchVO.setSearch_content(context);
            int totCnt = adminService.member_search_cnt(context);
            List<Member> member_list_search = adminService.member_list_search(searchVO);
            pagination.setTotalRecordCount(totCnt);
            searchVO.setEndDate(pagination.getLastPageNoOnPageList());
            searchVO.setStartDate(pagination.getFirstPageNoOnPageList());
            searchVO.setPrev(pagination.getXprev());
            searchVO.setNext(pagination.getXnext());
            model.addAttribute("memberList" , member_list_search);
            model.addAttribute("totCnt",totCnt);
            model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)searchVO.getPageUnit()));
            model.addAttribute("pagination",pagination);
        }
        return "admin/member";
    }

    @RequestMapping("member_detail")
    public String member_detail(String user_num,Model model) {

        Member user_info = adminService.user_info(user_num);
        List<HashMap> user_house = adminService.user_house(user_num);
        List<Community> user_community = adminService.user_community(user_num);
        List<Community_reply> user_reply = adminService.user_reply(user_num);
        List<Report> user_report = adminService.user_report(user_num);
        List<HashMap> user_contract = adminService.user_contract(user_num);
        model.addAttribute("user_info",user_info);
        model.addAttribute("user_house",user_house);
        model.addAttribute("user_community",user_community);
        model.addAttribute("user_reply",user_reply);
        model.addAttribute("user_report",user_report);
        model.addAttribute("user_contract",user_contract);

        return "admin/member_detail";
    }
    @RequestMapping("pw_change")
    public String pw_change(String user_num) {
        adminService.pw_change(user_num);
        return "redirect:/member_detail?user_num="+user_num;
    }


    @RequestMapping("member_delete")
    public String member_delete(String user_num) {
        adminService.member_delete(user_num);
        return "redirect:/admin/member";
    }

    @GetMapping("admin/notice")
    public String Notice_Control(Criteria criteria, Model model) {
        NoticeDTO.PageResponseList pageResponseList = noticeService.pageResponseList(criteria);
        model.addAttribute("pageList", pageResponseList);
        return "admin/notice";
    }

    @RequestMapping("/admin_notice_delete")
    public String admin_notice_delete(String notice_num) {
        adminService.notice_delete(notice_num);
        return "redirect:/admin/notice";
    }

    @RequestMapping("/notice_modify")
    public String notice_modify(String notice_num, Model model) {
        model.addAttribute("Notice", communityService.view_board(notice_num));
        return "admin/notice_modify";
    }

    @GetMapping("admin/community")
    public String admin_community(@ModelAttribute("searchVO") Community searchVO, HttpServletRequest request, Model model) {
        PageCtrl pagination  = new PageCtrl();
        pagination.setCurrentPageNo(searchVO.getPageIndex());
        pagination.setRecordCountPerPage(searchVO.getPageUnit());
        pagination.setPageSize(searchVO.getPageSize());
        pagination.setPageSize(searchVO.getPageSize());
        searchVO.setFirstIndex(pagination.getFirstRecordIndex());
        searchVO.setRecordCountPerPage(pagination.getRecordCountPerPage());
        String search = request.getParameter("searchName");
        String context = request.getParameter("searchValue");
        if(context == null){
            List<Community> bd_list = communityService.bd_list(searchVO);
            model.addAttribute("bd_list" , bd_list);
            int totCnt = communityService.bd_listCnt();
            model.addAttribute("totCnt",totCnt);
            pagination.setTotalRecordCount(totCnt);
            searchVO.setEndDate(pagination.getLastPageNoOnPageList());
            searchVO.setStartDate(pagination.getFirstPageNoOnPageList());
            searchVO.setPrev(pagination.getXprev());
            searchVO.setNext(pagination.getXnext());
            model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)searchVO.getPageUnit()));
            model.addAttribute("pagination",pagination);
        }
        else if(context != null && context == ""){
            List<Community> bd_list = communityService.bd_list(searchVO);
            model.addAttribute("bd_list" , bd_list);
            int totCnt = communityService.bd_listCnt();
            model.addAttribute("totCnt",totCnt);
            pagination.setTotalRecordCount(totCnt);
            searchVO.setEndDate(pagination.getLastPageNoOnPageList());
            searchVO.setStartDate(pagination.getFirstPageNoOnPageList());
            searchVO.setPrev(pagination.getXprev());
            searchVO.setNext(pagination.getXnext());
            model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)searchVO.getPageUnit()));
            model.addAttribute("pagination",pagination);
        }
        else{
            searchVO.setSearch_name(search);
            searchVO.setSearch_content(context);
            int totCnt = communityService.bd_list_search_Cnt(searchVO);
            List<Community> pg_list = communityService.bd_list_search(searchVO);
            pagination.setTotalRecordCount(totCnt);
            searchVO.setEndDate(pagination.getLastPageNoOnPageList());
            searchVO.setStartDate(pagination.getFirstPageNoOnPageList());
            searchVO.setPrev(pagination.getXprev());
            searchVO.setNext(pagination.getXnext());
            model.addAttribute("bd_list" , pg_list);
            model.addAttribute("totCnt",totCnt);
            model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)searchVO.getPageUnit()));
            model.addAttribute("pagination",pagination);
        }
        return "admin/community";
    }


    @RequestMapping("admin/community/delete")
    public String communoty_delete(String community_num,@ModelAttribute("searchVO") Community searchVO, HttpServletRequest request, Model model) {
        communityService.delete_board(community_num);
        adminService.delete_board_reply(community_num);
        return "redirect:/admin/community";
    }
    @RequestMapping("admin/community/modify")
    public String community_modify(String community_num, Model model) {
        model.addAttribute("Board", communityService.view_board(community_num));
        model.addAttribute("reply", communityService.view_reply(community_num));
        return "admin/community_modify";
    }

    @RequestMapping("admin/community/reply/update")
    public String community_reply_update(@ModelAttribute("searchVO") Community_reply searchVO, HttpServletRequest request, Model model) {
        String reply_num = request.getParameter("reply_num");
        adminService.comment_update_admin(reply_num);
        String num = adminService.get_community_num(reply_num);
        return "redirect:/admin/community/modify?community_num="+num;
    }
    //게시글 수정
    @RequestMapping("admin/community/update")
    public String board_modify_admin(Community community) {
        communityService.update_board(community);
        return "redirect:/admin/community";
    }
    @GetMapping("admin/reply")
    public String Reply_Control(@ModelAttribute("searchVO") Community_reply searchVO, HttpServletRequest request, Model model)
    {
        PageCtrl pagination  = new PageCtrl();
        pagination.setCurrentPageNo(searchVO.getPageIndex());
        pagination.setRecordCountPerPage(searchVO.getPageUnit());
        pagination.setPageSize(searchVO.getPageSize());
        searchVO.setFirstIndex(pagination.getFirstRecordIndex());
        searchVO.setRecordCountPerPage(pagination.getRecordCountPerPage());
        String search = request.getParameter("searchName");
        String context = request.getParameter("searchValue");

        if(context == null){
            List<Community_reply> reply = adminService.reply_list(searchVO);
            model.addAttribute("reply" , reply);
            int totCnt = adminService.reply_listCnt();
            model.addAttribute("totCnt",totCnt);
            pagination.setTotalRecordCount(totCnt);
            searchVO.setEndDate(pagination.getLastPageNoOnPageList());
            searchVO.setStartDate(pagination.getFirstPageNoOnPageList());
            searchVO.setPrev(pagination.getXprev());
            searchVO.setNext(pagination.getXnext());
            model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)searchVO.getPageUnit()));
            model.addAttribute("pagination",pagination);
        }
        else if(context != null && context == ""){
            List<Community_reply> reply = adminService.reply_list(searchVO);
            model.addAttribute("reply" , reply);
            int totCnt = adminService.reply_listCnt();
            model.addAttribute("totCnt",totCnt);
            pagination.setTotalRecordCount(totCnt);
            searchVO.setEndDate(pagination.getLastPageNoOnPageList());
            searchVO.setStartDate(pagination.getFirstPageNoOnPageList());
            searchVO.setPrev(pagination.getXprev());
            searchVO.setNext(pagination.getXnext());
            model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)searchVO.getPageUnit()));
            model.addAttribute("pagination",pagination);
        }
        else{
            searchVO.setSearch_name(search);
            searchVO.setSearch_content(context);
            int totCnt = adminService.reply_list_search_Cnt(searchVO);
            List<Community_reply> reply = adminService.reply_list_search(searchVO);
            pagination.setTotalRecordCount(totCnt);
            searchVO.setEndDate(pagination.getLastPageNoOnPageList());
            searchVO.setStartDate(pagination.getFirstPageNoOnPageList());
            searchVO.setPrev(pagination.getXprev());
            searchVO.setNext(pagination.getXnext());
            model.addAttribute("reply" , reply);
            model.addAttribute("totCnt",totCnt);
            model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)searchVO.getPageUnit()));
            model.addAttribute("pagination",pagination);
        }

        return "admin/reply";
    }

    @RequestMapping("admin/reply/update")
    public String reply_update(@ModelAttribute("searchVO") Community_reply searchVO, HttpServletRequest request, Model model) {
        String reply_num = request.getParameter("reply_num");
        adminService.comment_update_admin(reply_num);
        return "redirect:/admin/reply";
    }

    @GetMapping("admin/report")
    public String Report_List(@ModelAttribute("searchVO") Report searchVO, Model model) {
        PageCtrl pagination  = new PageCtrl();
        pagination.setCurrentPageNo(searchVO.getPageIndex());
        pagination.setRecordCountPerPage(searchVO.getPageUnit());
        pagination.setPageSize(searchVO.getPageSize());
        searchVO.setFirstIndex(pagination.getFirstRecordIndex());
        searchVO.setRecordCountPerPage(pagination.getRecordCountPerPage());
        List<Report> re_list = reportService.report_all(searchVO);
        model.addAttribute("re_list" , re_list);
        int totCnt = reportService.report_all_cnt();
        model.addAttribute("totCnt",totCnt);
        pagination.setTotalRecordCount(totCnt);
        searchVO.setEndDate(pagination.getLastPageNoOnPageList());
        searchVO.setStartDate(pagination.getFirstPageNoOnPageList());
        searchVO.setPrev(pagination.getXprev());
        searchVO.setNext(pagination.getXnext());
        model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)searchVO.getPageUnit()));
        model.addAttribute("pagination",pagination);
        return "admin/report";
    }

    @GetMapping("admin/house_approval")
    public String Approval_List(@ModelAttribute("searchVO") House_list searchVO, HttpServletRequest request, Model model) {
        PageCtrl pagination  = new PageCtrl();
        pagination.setCurrentPageNo(searchVO.getPageIndex());
        pagination.setRecordCountPerPage(searchVO.getPageUnit());
        pagination.setPageSize(searchVO.getPageSize());
        searchVO.setFirstIndex(pagination.getFirstRecordIndex());
        searchVO.setRecordCountPerPage(pagination.getRecordCountPerPage());
        String search = request.getParameter("searchName");
        String context = request.getParameter("searchValue");
        if(context == null){
            List<HashMap> re_list = adminService.re_list(searchVO);
            model.addAttribute("re_list" , re_list);
            int totCnt = adminService.re_list_cnt();
            model.addAttribute("totCnt",totCnt);
            pagination.setTotalRecordCount(totCnt);
            searchVO.setEndDate(pagination.getLastPageNoOnPageList());
            searchVO.setStartDate(pagination.getFirstPageNoOnPageList());
            searchVO.setPrev(pagination.getXprev());
            searchVO.setNext(pagination.getXnext());
            model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)searchVO.getPageUnit()));
            model.addAttribute("pagination",pagination);
        }
        else if(context != null && context == ""){
            List<HashMap> re_list = adminService.re_list(searchVO);
            model.addAttribute("re_list" , re_list);
            int totCnt = adminService.re_list_cnt();
            model.addAttribute("totCnt",totCnt);
            pagination.setTotalRecordCount(totCnt);
            searchVO.setEndDate(pagination.getLastPageNoOnPageList());
            searchVO.setStartDate(pagination.getFirstPageNoOnPageList());
            searchVO.setPrev(pagination.getXprev());
            searchVO.setNext(pagination.getXnext());
            model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)searchVO.getPageUnit()));
            model.addAttribute("pagination",pagination);
        }
        else{

        }

        return "admin/house_approval";
    }

    @RequestMapping("admin/house_approval/true")
    public String house_approval_ok(String house_num) {
        adminService.approval_ok_house_item(house_num);
        adminService.approval_ok_house_list(house_num);

        return "redirect:/admin/house_approval";
    }

    @RequestMapping("admin/house_approval/false")
    public String approval_no(String house_num) {
        adminService.approval_no_house_item(house_num);
        adminService.approval_no_house_list(house_num);
        return "redirect:/admin/house_approval";
    }

    @GetMapping("admin/false_approval")
    public String No_Approval_List(@ModelAttribute("searchVO") House_list searchVO, HttpServletRequest request, Model model) {
        PageCtrl pagination  = new PageCtrl();
        pagination.setCurrentPageNo(searchVO.getPageIndex());
        pagination.setRecordCountPerPage(searchVO.getPageUnit());
        pagination.setPageSize(searchVO.getPageSize());
        searchVO.setFirstIndex(pagination.getFirstRecordIndex());
        searchVO.setRecordCountPerPage(pagination.getRecordCountPerPage());

        List<HashMap> re_list = adminService.no_re_list(searchVO);
        model.addAttribute("re_list" , re_list);
        int totCnt = adminService.no_re_list_cnt();
        model.addAttribute("totCnt",totCnt);
        pagination.setTotalRecordCount(totCnt);
        searchVO.setEndDate(pagination.getLastPageNoOnPageList());
        searchVO.setStartDate(pagination.getFirstPageNoOnPageList());
        searchVO.setPrev(pagination.getXprev());
        searchVO.setNext(pagination.getXnext());
        model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)searchVO.getPageUnit()));
        model.addAttribute("pagination",pagination);

        return "admin/false_approval";
    }
    @RequestMapping("admin/false_approval/true")
    public String false_approval_true(String house_num) {
        adminService.approval_ok_house_item(house_num);
        adminService.approval_ok_house_list(house_num);
        return "redirect:/admin/false_approval";
    }
    @RequestMapping("house_info")
    public String house_info (String house_num,Model model) {
        List<House_list> house_list = houseService.view_house_list_one(house_num);
        List<House_item> house_item = houseService.list_house_item(house_num);
        List<House_addinfo> house_addinfo = houseService.add_info_list(house_num);
        List<House_detail> house_detail = houseService.house_detail_list(house_num);
        List<House_option> house_option = houseService.house_option_list(house_num);
        List<House_info> house_info = houseService.house_info_list(house_num);
        List<House_type> house_type = houseService.house_type_list(house_num);
        String road_address = houseService.road_address(house_num);
        List<House_picture> housePictures = houseService.house_picture_list(house_num);

        model.addAttribute("house_list",house_list);
        model.addAttribute("house_item",house_item);
        model.addAttribute("house_addinfo",house_addinfo);
        model.addAttribute("house_detail",house_detail);
        model.addAttribute("house_option",house_option);
        model.addAttribute("house_info",house_info);
        model.addAttribute("house_type",house_type);
        model.addAttribute("road_address",road_address);
        model.addAttribute("housePictures",housePictures);
        return "admin/house_info";
    }

    @GetMapping("admin_contract_list")
    public String Contract_Details(Criteria criteria, Model model) {
        ResponsePageDTO.ResponseContract list = contractService.contract_list(criteria);
        model.addAttribute("pageList", list);
        return "admin/contract_manage";
    }

    @GetMapping("admin_contract_detail")
    public String admin_contract_detail(String contract_idx, Model model) {
        Contract contract =  contractService.getContractDetail(contract_idx);
        model.addAttribute("contract",contract);
        model.addAttribute("lessoer",contractService.getLessoerInfo(contract.getLessoer_idx()));
        model.addAttribute("tenant",contractService.getTenantInfo(contract.getTenant_idx()));

        return "admin/admin_contract_detail";
    }

    @GetMapping("member_house_approve")
    public String member_house_approve(String house_num,String user_id) {
        adminService.approval_ok_house_item(house_num);
        adminService.approval_ok_house_list(house_num);
        String user_num = adminService.find_user_num(user_id);
        return "redirect:/member_detail?user_num="+user_num;
    }

    @GetMapping("member_house_cencel")
    public String member_house_cencel(String house_num,String user_id) {
        adminService.approval_no_house_item(house_num);
        adminService.approval_no_house_list(house_num);
        String user_num = adminService.find_user_num(user_id);
        return "redirect:/member_detail?user_num="+user_num;
    }

    @GetMapping("blind_reply")
    public String blind_reply(String reply_num,String user_id) {
        adminService.comment_update_admin(reply_num);
        String user_num = adminService.find_user_num(user_id);

        return "redirect:/member_detail?user_num="+user_num;
    }

    @GetMapping("/admin/house_cancel")
    public String house_cencel(String house_num) {
        System.out.println("asdf");
        adminService.approval_no_house_item(house_num);
        adminService.approval_no_house_list(house_num);
        return "redirect:/admin/report";
    }

    @GetMapping("Event_Check")
    public String Event_Check() {
        return "Admin_Dashboard/Event_Check";
    }

    @GetMapping("Event_Registration")
    public String Event_Registration() {
        return "Admin_Dashboard/Event_Registration";
    }

    @GetMapping("Member_Control")
    public String Member_Control() {
        return "Admin_Dashboard/Member_Control";
    }

    @GetMapping("Member_Withdrawal")
    public String Member_Withdrwal() {
        return "Admin_Dashboard/Member_Withdrawal";
    }

    @GetMapping("Statistics_Chart")
    public String Statistics_Chart() {
        return "Admin_Dashboard/Statistics_Chart";
    }

    @GetMapping("/admin/notice_add")
    public String AdminNoticeAdd() {
        return "admin/notice_add";
    }

    @GetMapping("/admin/notice_adds")
    public String BoardAdd(Notice notice) {
        noticeService.insert_notice(notice);
        return "redirect:/admin/notice_add";
    }

    @GetMapping("/admin/notice_delete")
    public String AdminNoticeDelete(String noticeNum) {
        noticeService.delete_notice(noticeNum);
        return "redirect:/admin/notice";}

    @GetMapping("/admin/notice_modify")
    public String AdminNoticeModify(Notice notice) {
        return null;}

    @GetMapping("/admin/notice_modifys")
    public String AdminNoticeModifies(Notice notice){

        return "redirect:/admin/notice_modify";
    }
}
