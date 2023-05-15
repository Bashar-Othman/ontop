/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ontop.spring.test.repository;

import com.ontop.spring.test.model.BeneficiaryTransaction;
 import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author BasharOthman
 */
@Repository
public interface BeneficiaryTransactionRepo extends JpaRepository<BeneficiaryTransaction, String> {

}
