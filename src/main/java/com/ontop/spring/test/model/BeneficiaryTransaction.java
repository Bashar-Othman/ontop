/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ontop.spring.test.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author BasharOthman
 */
//BeneficiaryTransaction
@Entity
@Table(name = "beneficiary_transaction")
@Getter
@Setter
public class BeneficiaryTransaction {

    @Id
    private String id;

    private String status;

    private Timestamp date;

    @OneToOne
    private Beneficiary accountNumber;
    
    private BigDecimal amount;

}
