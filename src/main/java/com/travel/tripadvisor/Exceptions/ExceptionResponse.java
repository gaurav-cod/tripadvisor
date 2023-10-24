package com.travel.tripadvisor.Exceptions;

public class ExceptionResponse {
    Integer errorCode;
    String errorMessage;

    public ExceptionResponse(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
