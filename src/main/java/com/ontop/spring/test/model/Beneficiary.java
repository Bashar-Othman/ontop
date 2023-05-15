/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ontop.spring.test.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author BasharOthman
 */
@Entity
@Table(name = "BENEFICIARIES")
@Getter
@Setter
public class Beneficiary implements Serializable {

    @Id
    private String id;

    @NotNull(message = " First Name must be Not Null")
    private String firstName;

    @NotNull(message = " Last Name must be Not Null")
    private String lastName;

    @NotNull(message = " Routing Number   must be Not Null")
    private String routingNumber;

    @NotNull(message = "National ID  must be Not Null")
    private String nationalIdentificationNumber;

    @NotNull(message = "Account Number be Not Null")
    @Column(unique = true)
    private String accountNumber;
    
    private BigDecimal amount ;
}
