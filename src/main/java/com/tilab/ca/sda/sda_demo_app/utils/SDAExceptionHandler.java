
package com.tilab.ca.sda.sda_demo_app.utils;

import com.tilab.ca.sda.sda_demo_app.exceptions.SdaError;
import com.tilab.ca.sda.sda_demo_app.exceptions.HttpStatusCodes;
import com.tilab.ca.sda.sda_demo_app.exceptions.SdaException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class SDAExceptionHandler extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler({SdaException.class})
    protected ResponseEntity<Object> handleNoDataAvailable(RuntimeException e, WebRequest request){
        SdaException ex=(SdaException)e;
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        SdaError error=new SdaError(ex.getMessage(), ex.getHttpStatusCode(), ex.getInternalCode());
        
        return handleExceptionInternal(e, error, headers, fromHttpStatusCode(ex.getHttpStatusCode()), request);
    }
    
    public HttpStatus fromHttpStatusCode(int httpStatusCode){
        switch(httpStatusCode){
            case HttpStatusCodes.BAD_REQUEST:
                return HttpStatus.BAD_REQUEST;
            case HttpStatusCodes.NOT_FOUND:
                return HttpStatus.NOT_FOUND;
            case HttpStatusCodes.INTERNAL_SERVER_ERROR:
                return HttpStatus.INTERNAL_SERVER_ERROR;
            default: 
                return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
