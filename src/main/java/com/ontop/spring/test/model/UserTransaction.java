/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ontop.spring.test.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author BasharOthman
 */
@Entity
@Table(name = "USER_TRANSACTIONS")
@Data
public class UserTransaction implements Serializable {

    @Id
    private String id;

    private Long userId;

    private Long transactionId;

    private BigDecimal transactionAmount;

    private BigDecimal walletSattlement;

    private Timestamp transactionDateTime;

    private String currency;

    private String transactionType;

    private String transactionDescription;

    private boolean isSuccessful;

}
