package cn.itike.iutils.commons;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import java.util.Map;
import java.util.UUID;

public class CommonUtils {
    public static String uuId(){
        return UUID.randomUUID().toString().replace("-","").toUpperCase();
    }
    @SuppressWarnings("rawtypes")
    public static <T> T toBean(Map<String, ?> map, Class<T> clazz) {
        try {
            T bean = clazz.getDeclaredConstructor().newInstance();
            ConvertUtils.register(new DateConverter(),java.util.Date.class);
            BeanUtils.populate(bean,map);
            return bean;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
