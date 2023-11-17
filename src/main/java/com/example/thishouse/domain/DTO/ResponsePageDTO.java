package com.example.thishouse.domain.DTO;

import com.example.thishouse.domain.PageDTO;
import com.example.thishouse.domain.contract.Contract;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;


public class ResponsePageDTO {
    @Data
    @AllArgsConstructor
    public static class ResponseContract {
        private List<HashMap> contract;
        private PageDTO pageDTO;
    }
}
