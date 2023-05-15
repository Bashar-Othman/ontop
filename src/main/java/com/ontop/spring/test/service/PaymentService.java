/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ontop.spring.test.service;

 
import com.ontop.spring.test.model.request.PaymentRequest;
import com.ontop.spring.test.model.response.PaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author BasharOthman
 */
@Service
public interface PaymentService {


    PaymentResponse sendMoney(PaymentRequest paymentRequest);

}
