package com.ps.exception;

/**
 * this is for Http 401 unauthorized request exception
 */
public class UnAuthorizedException extends RuntimeException {
private final String errorCode;

    public UnAuthorizedException(String errorMessage,String errorCode) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
