package com.ontop.spring.test.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 *
 * @author BasharOthman
 */
@Data
@AllArgsConstructor
public class OnTopError {

    private String code;
    private String message;

}
