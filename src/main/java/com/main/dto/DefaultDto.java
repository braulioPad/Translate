package com.main.dto;

public class DefaultDto {

    private String errorMessage;

    public DefaultDto() {
        // Default constructor
    }

    public DefaultDto(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
