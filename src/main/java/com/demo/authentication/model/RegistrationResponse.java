package com.demo.authentication.model;

public class RegistrationResponse{
    private String username;

    public RegistrationResponse(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
