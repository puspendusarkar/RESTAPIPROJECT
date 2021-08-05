package com.ps.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundException ex){
        ExceptionResponse exceptionResponse=new ExceptionResponse();
        exceptionResponse.setErrorCode(ErrorCode.HTTP_RESOURCE_NOT_FOUND_EXCEPTION);
        exceptionResponse.setErrorMessage(ex.getMessage());
        exceptionResponse.setLocalDateTime(LocalDateTime.now());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(UnAuthorizedException.class)
    public ResponseEntity<ExceptionResponse> unAuthorizedRequest(UnAuthorizedException ex){
        ExceptionResponse exceptionResponse= new ExceptionResponse();
        exceptionResponse.setErrorCode(ErrorCode.HTTP_UNAUTHORIZED_EXCEPTION);
        exceptionResponse.setErrorMessage(ex.getMessage());
        exceptionResponse.setLocalDateTime(LocalDateTime.now());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(ResourceAlreadyExists.class)
    public ResponseEntity<ExceptionResponse> resourceAlreadyExists(ResourceAlreadyExists ex){
        ExceptionResponse exceptionResponse=new ExceptionResponse();
        exceptionResponse.setErrorCode(ErrorCode.HTTP_RESOURCE_ALREADY_EXISTS_EXCEPTION);
        exceptionResponse.setErrorMessage(ex.getMessage());
        exceptionResponse.setLocalDateTime(LocalDateTime.now());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.CONFLICT);

    }
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ExceptionResponse> businessException(BusinessException ex){
        ExceptionResponse exceptionResponse=new ExceptionResponse();
        exceptionResponse.setErrorCode(ex.getErrorCode());
        exceptionResponse.setErrorMessage(ex.getMessage());
        exceptionResponse.setLocalDateTime(LocalDateTime.now());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.BAD_REQUEST);
    }
}
