package com.example.thishouse.api;

import com.example.thishouse.domain.Report;
import com.example.thishouse.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/api/getReport")
    public Report getReportInfo(@RequestParam("reportNum") int reportNum) {
        Report report = reportService.getReportInfo(reportNum);
        return report;
    }
}
