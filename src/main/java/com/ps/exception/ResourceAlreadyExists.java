package com.ps.exception;

public class ResourceAlreadyExists extends RuntimeException{
    private final String errorCode;

    public ResourceAlreadyExists(String errorMessage,String errorCode) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
