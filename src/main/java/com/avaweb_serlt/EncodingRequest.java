package com.avaweb_serlt;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.io.UnsupportedEncodingException;

/**
 * 装饰request
 */
public class EncodingRequest extends HttpServletRequestWrapper {
    private HttpServletRequest httpServletRequest;

    public EncodingRequest(HttpServletRequest request) {
        super(request);
        this.httpServletRequest = request;
    }
    public String getParameter(String s){
        String value = httpServletRequest.getParameter(s);
        try {
            value = new String(value.getBytes("iso-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return value;
    }

}
