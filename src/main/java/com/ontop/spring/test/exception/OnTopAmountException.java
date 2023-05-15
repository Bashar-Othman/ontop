package com.ontop.spring.test.exception;

import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author BasharOthman
 */
public class OnTopAmountException extends OnTopTransactionException {

    @Value("")
    private String msg;

    @Value("")
    private String code;
}
