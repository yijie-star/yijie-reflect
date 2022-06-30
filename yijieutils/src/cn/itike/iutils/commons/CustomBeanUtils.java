package cn.itike.iutils.commons;


import cn.itike.iutils.rests.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//定义BeanUtils类，该工具类主要实现属性的设置
public class CustomBeanUtils {
        private CustomBeanUtils(){}

        /**
         * 实现指定对象的属性设置
         * @param obj 要进行反射操作的实例化对象
         * @param value 包含有指定内容的字符串，格式：“属性:内容|属性:内容|属性:内容”
         */
        public static void setValue(Object obj,String value){
            String results []= value.split("\\|");//按照竖线进行内容每一组的拆分
            for (int i = 0; i < results.length; i++) {//循环设置属性内容
                //attval[0]保存属性名称，attval[1]保存属性内容
                String attval []= results[i].split(":");//获取“属性名称”和“属性内容
                try {
                    if (attval[0].contains(".")){//多级配置
                        String temp [] = attval[0].split("\\.");
                        Object currentObject = obj;
                        //最后一一位肯定是指定类中的属性名称,所以不在本次实例化处理的范畴之内
                        for (int j = 0; j < temp.length - 1; j++) {
                            //调用get方法,若返回为null,则表示未实例化
                            Method getMethod = obj.getClass().getDeclaredMethod("get" + StringUtils.initcap(temp[j]));
                            Object tempObject = getMethod.invoke(currentObject);
                            if (tempObject == null){//该对象并没有被实例化
                                Field file = currentObject.getClass().getDeclaredField(temp[j]);//获取属性类型
                                Method setMethod = currentObject.getClass().getDeclaredMethod("set" + StringUtils.initcap(temp[j]), file.getType());
                                Object newObject = file.getType().getConstructor().newInstance();
                                setMethod.invoke(currentObject,newObject );//实例化
                                currentObject = newObject;
                            }else {
                                currentObject = tempObject;
                            }
                        }
                        //进行属性内容的设置
                        Field field = currentObject.getClass().getDeclaredField(temp[temp.length - 1]);//获取成员
                        Method setMethod = currentObject.getClass().getDeclaredMethod("set" + StringUtils.initcap(temp[temp.length - 1]), field.getType());
                        Object convertAttributeValueval = convertAttributeValue(field.getType().getName(),attval[1]);
                        //setMethod.invoke(currentObject, attval[1]);//调用setter方法设置内容
                        setMethod.invoke(currentObject, convertAttributeValueval);//改变后的
                    }else {//单级配置
                        Field field = obj.getClass().getDeclaredField(attval[0]);//获取成员
                        Method setMethod = obj.getClass().getDeclaredMethod("set" + StringUtils.initcap(attval[0]), field.getType());
                        Object convertAttributeValueval = convertAttributeValue(field.getType().getName(),attval[1]);
                        //setMethod.invoke(obj, attval[1]);//调用setter方法设置内容
                        setMethod.invoke(obj, convertAttributeValueval);//改变后的
                    }

                }catch (Exception e){}
            }
        }

        /**
         * 实现属性类型转换处理
         * @param type 属性的类型,通过Field获取
         * @param value 属性内容传入的都是字符串,需要将其变为指定类型
         * @return 转换后的数据
         */
        private static Object convertAttributeValue(String type,String value){
            if ("long".equals(type) || "java.lang.Long".equals(type)){//长整型
                return Long.parseLong(value);
            }else if ("int".equals(type) || "java.lang.int".equals(type)){
                return Integer.parseInt(value);
            }else if ("double".equals(type) || "java.lang.double".equals(type)){
                return Double.parseDouble(value);
            }else if ("java.util.Date".equals(type)){
                SimpleDateFormat simpleDateFormat = null;
                if (value.matches("\\d{4}-\\d{2}-\\d{2}")){//日期类型
                    simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                }else if (value.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")){
                    simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                }else {
                    return new Date();//当前日期
                }
                try {
                    return simpleDateFormat.parse(value);
                } catch (ParseException e) {
                    return new Date();
                }
            }else {
                return value;
            }
        }
}

