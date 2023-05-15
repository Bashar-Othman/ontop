package com.ontop.spring.test.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 *
 * @author BasharOthman
 */
@Getter
public class RestApiErrorDetail {

    @JsonIgnore
    private  HttpStatus status;
    private  String message;
    private  String code;
 
    public RestApiErrorDetail() {
    }

    public RestApiErrorDetail(HttpStatus status, String message, String code) {
        super();
        this.status = status;
        this.message = message;
        this.code = code;
        //this.errors = errors;
    }

    public RestApiErrorDetail(HttpStatus status, String message, String error, String code) {
        super();
        this.status = status;
        this.message = message;
        this.code = code;
        //errors = Arrays.asList(error);
    }
}
