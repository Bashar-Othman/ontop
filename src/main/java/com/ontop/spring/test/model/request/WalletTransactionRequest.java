/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ontop.spring.test.model.request;

import com.ontop.spring.test.validation.AmountConstraint;
import com.ontop.spring.test.validation.UserIdConstraint;
import com.fasterxml.jackson.annotation.JsonProperty;
 import java.math.BigDecimal;
import lombok.Data;

/**
 *
 * @author BasharOthman
 */
@Data
public class WalletTransactionRequest {

    @JsonProperty("amount")
    @AmountConstraint
    private BigDecimal amount;

    @JsonProperty("user_id")
    @UserIdConstraint
    private Long userId;
}

/*

{
    "amount": 2000,
    "user_id": 1000.
}

 */
