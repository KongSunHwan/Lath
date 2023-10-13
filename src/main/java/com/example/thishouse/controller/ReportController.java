package com.example.thishouse.controller;

import com.example.thishouse.domain.Report;
import com.example.thishouse.service.ReportService;
import com.example.thishouse.util.FileUpload;
import com.example.thishouse.util.PageCtrl;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;
    @PostMapping("/report_insert")
    public String report_insert(@Valid Report report, BindingResult bindingResult,
                                @RequestParam("report_content_pic") MultipartFile report_content_pic,
                                @RequestParam("report_seller_pic") MultipartFile report_seller_pic,
                                @RequestParam("report_house_pic") MultipartFile report_house_pic,
                                Model model,
                                HttpSession session) {

        FileUpload fu = new FileUpload();

        fu.processFile(report_content_pic, "report_content_pic", report);
        fu.processFile(report_seller_pic, "report_seller_pic", report);
        fu.processFile(report_house_pic, "report_house_pic", report);

        String user_id = (String) session.getAttribute("user_id");
        report.setUser_id(user_id);
        reportService.insertReport(report);

        return "redirect:/main";
    }

    @GetMapping("/api/getReport")
    @ResponseBody
    public Report getReportInfo(@RequestParam("reportNum") int reportNum) {
        Report report = reportService.getReportInfo(reportNum);
        return report;
    }

    @RequestMapping("/user_report_list")
    public String user_report_list(@ModelAttribute("searchVO") Report searchVO, Model model,HttpSession session) {
        PageCtrl pagination  = new PageCtrl();
        pagination.setCurrentPageNo(searchVO.getPageIndex());
        pagination.setRecordCountPerPage(searchVO.getPageUnit_house());
        pagination.setPageSize(searchVO.getPageSize());

        searchVO.setFirstIndex(pagination.getFirstRecordIndex());
        searchVO.setRecordCountPerPage(pagination.getRecordCountPerPage());
        String user_id = (String) session.getAttribute("user_id");
        searchVO.setUser_id(user_id);

        List<Report> re_list = reportService.user_report(searchVO);
        model.addAttribute("re_list" , re_list);
        int totCnt = reportService.user_report_cnt(user_id);
        model.addAttribute("totCnt",totCnt);
        pagination.setTotalRecordCount(totCnt);
        searchVO.setEndDate(pagination.getLastPageNoOnPageList());
        searchVO.setStartDate(pagination.getFirstPageNoOnPageList());
        searchVO.setPrev(pagination.getXprev());
        searchVO.setNext(pagination.getXnext());
        model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)searchVO.getPageUnit()));
        model.addAttribute("pagination",pagination);

        return "user/user_reportList";
    }

}
