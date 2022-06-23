package com.avaweb_xml;

public class StuFactory {
    private StuFactory(){}
    public static Sms_service getInstance(){
        return new StuServiceImpl();
    }
}
