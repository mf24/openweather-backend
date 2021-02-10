package com.mfrac.weatherapp.Model;

public class Error {

    private String description;
    private String errorType;

    public Error(String description, String errorType) {
        this.description = description;
        this.errorType = errorType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }



}
