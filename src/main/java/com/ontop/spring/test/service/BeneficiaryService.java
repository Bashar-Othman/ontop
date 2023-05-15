/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ontop.spring.test.service;

import com.ontop.spring.test.model.request.BeneficiaryRequest;
import com.ontop.spring.test.model.response.BeneficiaryResponse;
import com.ontop.spring.test.model.response.PaymentResponse;
 import org.springframework.stereotype.Service;

/**
 *
 * @author BasharOthman
 */
@Service
public interface BeneficiaryService {

    BeneficiaryResponse createBeneficiary(BeneficiaryRequest beneficiaryRequest);

    PaymentResponse sendMoney(BeneficiaryRequest beneficiaryRequest);

    BeneficiaryResponse updateBeneficiary(BeneficiaryRequest beneficiaryRequest);

}
