package com.ps.exception;

public class BusinessException extends RuntimeException{
    private final String errorCode;

    public BusinessException(String errorMessage,String errorCode) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
