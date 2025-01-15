package com.challenge.api.controller;

import com.challenge.api.dto.CustomerRequest;
import com.challenge.api.dto.LoanResponse;
import com.challenge.api.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-loans")
public class LoansController {

    private final LoanService loanService;

    public LoansController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    public ResponseEntity<?> getAvailableLoans(@RequestBody CustomerRequest request) {
        LoanResponse response = loanService.getAvailableLoans(request);

        return ResponseEntity.ok(response);
    }
}
