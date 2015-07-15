package com.tilab.ca.sda.sda_demo_app.exceptions;


public class SdaException extends RuntimeException{
    
    private int httpStatusCode;
    private int internalCode;

    public SdaException(String message, int httpStatusCode, int internalCode) {
        super(message);
        this.httpStatusCode = httpStatusCode;
        this.internalCode = internalCode;
    }
    
    public SdaException(String message, int httpStatusCode, int internalCode,Exception e) {
        super(message,e);
        this.httpStatusCode = httpStatusCode;
        this.internalCode = internalCode;
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
