package com.example.thishouse.controller.restAPI;

import com.example.thishouse.domain.Criteria;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/contract")
@RequiredArgsConstructor
@RestController
public class ContractRestController {

    @PostMapping("/accept")
    public void acceptContract(){

    }

    @PostMapping("/refuse")
    public void refuseContract() {

    }
}
