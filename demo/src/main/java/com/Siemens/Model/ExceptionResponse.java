package com.Siemens.Model;

import java.time.LocalDateTime;

public class ExceptionResponse {
    private String message;
    private String exception;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public void setErrorMessage(String message) {
        this.message=message;
    }

    public void setErrorCode(String exception) {
        this.exception=exception;
    }

}
