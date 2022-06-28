package cn.ijike.iutils.rests;

public class Factory {
    private Factory(){}
    /**
     * 获取接口实例化对象
     * @param str 接口的子类
     * @param clazz 描述的是接口的类型
     * @return 如果接口存在则返回接口实例化对象
     * @param <T>
     */
    public static <T> T getInstance(String str,Class<T> clazz) {
        T instance = null;
        try {
            instance = (T)Class.forName(str).getDeclaredConstructor().newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return instance;
    }
}
