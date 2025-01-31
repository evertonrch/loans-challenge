package com.challenge.api.controller;

import com.challenge.api.dto.CustomerRequest;
import com.challenge.api.dto.LoanResponse;
import com.challenge.api.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @ExceptionHandler(IllegalArgumentException.class)
    public ProblemDetail handleIllegalArgumentException(IllegalArgumentException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        problemDetail.setDetail(ex.getMessage());
        return problemDetail;
    }
}
