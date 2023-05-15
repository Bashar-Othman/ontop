package com.ontop.spring.test.controller;

import com.ontop.spring.test.model.request.WalletTransactionRequest;
import com.ontop.spring.test.model.response.BalanceResponse;
import com.ontop.spring.test.model.response.TransactionResponse;
import com.ontop.spring.test.service.TransactionService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author BasharOthman
 */
@RestController
@RequestMapping("wallets")
@RequiredArgsConstructor
public class WalletTransactionController {

    private final TransactionService paymentService;

    @PostMapping("transactions")
    public ResponseEntity<TransactionResponse> sendMoney(@Valid @RequestBody WalletTransactionRequest paymentRequest) {

        TransactionResponse paymentResponse = paymentService.sendMoney(paymentRequest);

        return new ResponseEntity<>(paymentResponse, HttpStatus.OK);
    }

    @GetMapping("balance")
    public BalanceResponse userBalance(@Valid @RequestParam("user_id") String userId) {

        return paymentService.userBalance(userId);
    }
}
