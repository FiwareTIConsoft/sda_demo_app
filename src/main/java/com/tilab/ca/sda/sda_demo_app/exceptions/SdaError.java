package com.tilab.ca.sda.sda_demo_app.exceptions;


public class SdaError {
    
    private String message;
    private int httpStatusCode;
    private int internalCode;

    public SdaError(String message, int httpStatusCode, int internalCode) {
        this.message = message;
        this.httpStatusCode = httpStatusCode;
        this.internalCode = internalCode;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public int getInternalCode() {
        return internalCode;
    }

    public void setInternalCode(int internalCode) {
        this.internalCode = internalCode;
    }
    
    
}
