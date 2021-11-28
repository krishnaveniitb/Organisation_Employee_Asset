package com.Siemens.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExceptionClass extends RuntimeException {

    public String getMessage() {
        return message;
    }

    public ExceptionClass(String message, String message1) {
        super(message);
        this.message = message1;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

}
