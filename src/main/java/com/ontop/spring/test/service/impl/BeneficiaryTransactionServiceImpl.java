/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ontop.spring.test.service.impl;

 
import com.ontop.spring.test.model.BeneficiaryTransaction;
import com.ontop.spring.test.repository.BeneficiaryTransactionRepo;
import com.ontop.spring.test.service.BeneficiaryTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author BasharOthman
 */
@Service
@RequiredArgsConstructor
public class BeneficiaryTransactionServiceImpl implements BeneficiaryTransactionService {

    private final BeneficiaryTransactionRepo beneficiaryTransactionRepo;

    @Override
    public BeneficiaryTransaction createTransaction(BeneficiaryTransaction beneficiaryTransaction) {

        beneficiaryTransactionRepo.save(beneficiaryTransaction);
        return beneficiaryTransaction;
    }

}
