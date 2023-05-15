package com.ontop.spring.test.exception;

 
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author BasharOthman
 */
@ControllerAdvice
public class OnTopExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = {IllegalArgumentException.class, IllegalStateException.class})
    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request) {
        RestApiErrorDetail apiError
                = new RestApiErrorDetail(HttpStatus.BAD_REQUEST, "INVALID BASHAR", "INVAVAV");

        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        String msg = SystemErrors.ARGS_MUST_BE_NOT_NULL.msg;
        String code = SystemErrors.ARGS_MUST_BE_NOT_NULL.code;

        System.out.println(ex.getMessage());
        RestApiErrorDetail apiError
                = new RestApiErrorDetail(HttpStatus.BAD_REQUEST, msg, code);

        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    public final ResponseEntity handleAllExceptions(Exception ex) {
        // Log and return
        return new ResponseEntity<>("YOUR REQUEST PARAMS NOT MATCH!", HttpStatus.BAD_REQUEST);

    }

    @Override
    public ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        // Do your code here
        return new ResponseEntity<>("YOUR REQUEST PARAMS NOT MATCH!", HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String msg = SystemErrors.ARGS_MUST_BE_NOT_NULL.msg;
        String code = SystemErrors.ARGS_MUST_BE_NOT_NULL.code;

        //System.out.println(ex.getMessage());
        RestApiErrorDetail apiError
                = new RestApiErrorDetail(HttpStatus.BAD_REQUEST, msg, code);
        return buildResponseEntity(apiError);
    }

    private ResponseEntity<Object> buildResponseEntity(RestApiErrorDetail apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

}
