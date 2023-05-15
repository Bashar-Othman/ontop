/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ontop.spring.test.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author BasharOthman
 */
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AmountConstraintImpl.class)
public @interface AmountConstraint {

    String message() default "Must be greater than Zero ( 0 )";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
