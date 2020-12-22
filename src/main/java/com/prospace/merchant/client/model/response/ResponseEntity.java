package com.prospace.merchant.client.model.response;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ResponseEntity implements Serializable {

    private Map<String, String> headers;
    private List<String> body;
    private String statusCode;
    private int statusCodeValue;

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public List<String> getBody() {
        return body;
    }

    public void setBody(List<String> body) {
        this.body = body;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCodeValue() {
        return statusCodeValue;
    }

    public void setStatusCodeValue(int statusCodeValue) {
        this.statusCodeValue = statusCodeValue;
    }
}