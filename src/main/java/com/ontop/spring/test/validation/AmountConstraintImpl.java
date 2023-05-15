/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ontop.spring.test.validation;

import com.ontop.spring.test.exception.OnTopInsufficiebntFundException;
import com.ontop.spring.test.model.User;
import com.ontop.spring.test.service.UserService;
 
import java.math.BigDecimal;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;


/**
 *
 * @author BasharOthman
 */
@RequiredArgsConstructor
public class AmountConstraintImpl implements ConstraintValidator<AmountConstraint, BigDecimal> {

     private final UserService userService;

    @Override
    public boolean isValid(BigDecimal amount, ConstraintValidatorContext context) {

        String username = "Bashar";//userDetails.getUsername();
        User user = userService.userInfoByName(username).get();

        BigDecimal res = user.getWalletAmount().add(amount);
        if (res.compareTo(BigDecimal.ZERO) < 0 && amount.compareTo(BigDecimal.ZERO) < 0) {

            throw new OnTopInsufficiebntFundException("Insufficient Fund " + user.getWalletAmount());
        }

        return amount != null && (amount.compareTo(BigDecimal.ZERO) != 0);
    }

}
