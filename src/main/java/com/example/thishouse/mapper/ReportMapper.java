package com.example.thishouse.mapper;

import com.example.thishouse.domain.Report;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReportMapper {

    public void insertReport(Report report);
}
