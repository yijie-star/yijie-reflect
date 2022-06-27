package cn.iutils;

import java.util.UUID;

public class CommonUtils {
    public static String uuId(){
        return UUID.randomUUID().toString().replace("-","").toUpperCase();
    }
}
