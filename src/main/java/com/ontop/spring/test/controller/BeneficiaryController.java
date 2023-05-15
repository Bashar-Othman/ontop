package com.ontop.spring.test.controller;

import com.ontop.spring.test.model.request.BeneficiaryRequest;
import com.ontop.spring.test.model.response.BeneficiaryResponse;
import com.ontop.spring.test.model.response.PaymentResponse;
import com.ontop.spring.test.service.BeneficiaryService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author BasharOthman
 */
@RestController
@RequestMapping("api/v1/beneficiarys")
@RequiredArgsConstructor
public class BeneficiaryController {

    
    private final BeneficiaryService beneficiaryService;

    @PutMapping
    public ResponseEntity<BeneficiaryResponse> updateBeneficiary(@Valid @RequestBody BeneficiaryRequest beneficiaryRequest) {

        BeneficiaryResponse beneficiaryResponse = new BeneficiaryResponse();
        return new ResponseEntity<>(beneficiaryResponse, HttpStatus.OK);
    }

    @PostMapping("beneficiary")
    public ResponseEntity<BeneficiaryResponse> createBeneficiary(@Valid @RequestBody BeneficiaryRequest beneficiaryRequest) {

        BeneficiaryResponse beneficiaryResponse = beneficiaryService.createBeneficiary(beneficiaryRequest);
        return new ResponseEntity<>(beneficiaryResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PaymentResponse> sendMoney(@Valid @RequestBody BeneficiaryRequest beneficiaryRequest) {

        PaymentResponse paymentResponse = beneficiaryService.sendMoney(beneficiaryRequest);
        return new ResponseEntity<>(paymentResponse, HttpStatus.OK);
    }
}
