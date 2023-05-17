/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ontop.spring.test.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author BasharOthman
 */
public class FirstNameLastNameConstraintImpl implements ConstraintValidator<FirstNameLastNameConstraint, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Pattern p = Pattern.compile("[^A-Za-z ]");
        Matcher matcher = p.matcher(value);
        if (!matcher.find()) {
            return false;
        }

        return true;

    }
}
