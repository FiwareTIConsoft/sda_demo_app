package com.tilab.ca.sda.sda_demo_app.http;


public interface HttpConnector {
    
    /**
     * 
     * @param url the url to call
     * @return the status code of the call (200 if ok, other codes depending of the issue otherwise) 
     */
    public int voidGet(String url);
}
