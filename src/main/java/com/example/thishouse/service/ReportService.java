package com.example.thishouse.service;

import com.example.thishouse.domain.Report;
import com.example.thishouse.mapper.ReportMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReportService {


        private final ReportMapper reportMapper;

        public void insertReport(Report report) {
            reportMapper.insertReport(report);
        }
}
