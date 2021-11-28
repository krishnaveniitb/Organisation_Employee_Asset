package com.Siemens.Exception;

import com.Siemens.Model.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoValueFoundException.class)
    public ResponseEntity<ExceptionResponse> NoValueFoundException(NoValueFoundException ex) {
        ExceptionResponse response=new ExceptionResponse();
        response.setErrorCode("INVALID");
        response.setErrorMessage(ex.getMessage());
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
    }
}
