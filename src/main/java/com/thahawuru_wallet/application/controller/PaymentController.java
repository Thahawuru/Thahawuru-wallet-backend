package com.thahawuru_wallet.application.controller;

import com.thahawuru_wallet.application.dto.response.ApiResponse;
import com.thahawuru_wallet.application.dto.response.PaymentDTO;
import com.thahawuru_wallet.application.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/apikey/{amount}")
    public ResponseEntity<ApiResponse<PaymentDTO>> makepayment (@PathVariable double amount){

        PaymentDTO payment = paymentService.makePayment(amount);
        return   new ResponseEntity<>(new ApiResponse<>(HttpStatus.OK.value(),payment,"success"),HttpStatus.OK);
    }
}
