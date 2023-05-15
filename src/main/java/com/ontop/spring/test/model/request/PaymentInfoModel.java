/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ontop.spring.test.model.request;

import java.math.BigDecimal;
import lombok.Data;

/**
 *
 * @author BasharOthman
 */

@Data
public class PaymentInfoModel {
    
    private BigDecimal amount;
    
    private String id;
}
