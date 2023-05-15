package com.ontop.spring.test.controller;


import com.ontop.spring.test.model.request.PaymentRequest;
import com.ontop.spring.test.model.response.PaymentResponse;
import com.ontop.spring.test.service.PaymentService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author BasharOthman
 */
@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class WalletPaymentController {

    private final PaymentService paymentService;

    @GetMapping
    public String Test(@Valid @RequestBody PaymentRequest paymentRequest) {
        return "JSJSJ";
    }

    @PostMapping
    public ResponseEntity<PaymentResponse> sendMoney(@Valid @RequestBody PaymentRequest paymentRequest) {
        System.out.println("Wallet Payment Controller : sendMoneyDDDD");
        PaymentResponse paymentResponse = paymentService.sendMoney(paymentRequest);
        return new ResponseEntity<>(paymentResponse, HttpStatus.OK);
    }
}
