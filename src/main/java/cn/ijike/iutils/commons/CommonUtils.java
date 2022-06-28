package cn.ijike.iutils.commons;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;
import java.util.UUID;

public class CommonUtils {
    public static String uuId(){
        return UUID.randomUUID().toString().replace("-","").toUpperCase();
    }
    @SuppressWarnings("rawtypes")
    public static <T> T toBean(Map map,Class<T> clazz) {
        try {
            T bean = clazz.getDeclaredConstructor().newInstance();
//            ConverUtils.register(new DateConverter(),java.util.Date.class);
            BeanUtils.populate(bean,map);
            return bean;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
