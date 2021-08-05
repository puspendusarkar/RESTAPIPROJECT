package com.ps.exception;

public class ResourceNotFoundException extends RuntimeException{

    private final String errorCode;

    public ResourceNotFoundException(String errorMessage,String errorCode) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
