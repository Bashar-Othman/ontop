/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ontop.spring.test.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ontop.spring.test.model.request.PaymentInfoModel;
import com.ontop.spring.test.model.request.RequestPaymentInfoModel;

 import lombok.Data;

/**
 *
 * @author BasharOthman
 */
@Data
public class PaymentResponse {

    @JsonProperty("requestInfo")
    private RequestPaymentInfoModel requestPaymentInfoModel;

    @JsonProperty("paymentInfo")
    private PaymentInfoModel paymentInfor;
}
