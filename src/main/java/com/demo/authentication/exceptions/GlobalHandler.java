package com.demo.authentication.exceptions;

import com.demo.authentication.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception exception) {
        return new ResponseEntity(new ErrorResponse("INTERNAL_SERVER_ERROR", exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ClientApiException.class)
    public ResponseEntity<ErrorResponse> handleClientException(ClientApiException exception) {
        return new ResponseEntity(new ErrorResponse("BAD_REQUEST", exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
