/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ontop.spring.test.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.Data;

/**
 *
 * @author BasharOthman
 */
@Data
public class TransactionResponse {

    @JsonProperty("wallet_transaction_id")
    private Long walletTransactionId;

    @JsonProperty("amount")
    private BigDecimal amount;

    @JsonProperty("user_id")
    private Long userId;
}

/*
@RestController
@RequestMapping("/api/v1/payments")

{
    "wallet_transaction_id": 66319,
    "amount": 2000,
    "user_id": 1000
}
 */
