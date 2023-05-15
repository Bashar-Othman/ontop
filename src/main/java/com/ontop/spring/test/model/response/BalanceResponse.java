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
public class BalanceResponse {

    @JsonProperty("balance")
    private BigDecimal balance;

    @JsonProperty("user_id")
    private Long userId;

}
