package com.iocs.spring.beans.exception;

public class ExceptionDetails {

    public String message;

    public ExceptionDetails(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
