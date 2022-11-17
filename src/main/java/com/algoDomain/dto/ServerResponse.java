package com.algoDomain.dto;

public class ServerResponse {
    private String message;

    public String getMessage() {
        return message;
    }

    public ServerResponse() {
    }

    public ServerResponse(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
