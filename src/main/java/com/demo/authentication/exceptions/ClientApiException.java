package com.demo.authentication.exceptions;

public class ClientApiException extends RuntimeException{
    private String message;

    public ClientApiException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}