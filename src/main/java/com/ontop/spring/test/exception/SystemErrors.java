package com.ontop.spring.test.exception;

import org.springframework.http.HttpStatus;
/**
 *
 * @author BasharOthman
 */
public enum SystemErrors {

    ARGS_MUST_BE_NOT_NULL("amount and user_id must not be null", HttpStatus.BAD_REQUEST.value(), "INVALID_BODY"),
    USERID_MUST_BE_NOT_BE_ZERO("amount and user_id must not be equal to Zero ( 0 ) ", HttpStatus.BAD_REQUEST.value(), "INVALID_BODY"),
    USER_RESOURCE_NOT_FOUND("user not found", HttpStatus.NOT_FOUND.value(), "user not found"),
    SOMTHING_BAD_HAPPENED("HttpStatus.BAD_REQUEST.value()", HttpStatus.INTERNAL_SERVER_ERROR.value(), "something bad happened");

    public final String msg;
    public final String code;
    public final int status;

    private SystemErrors(String val, int statusVal, String codeVal) {
        msg = val;
        code = codeVal;
        status = statusVal;
    }
}
