/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: java_reflex_agent.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

/*
 * @Created by IntelliJ IDEA.
 * @fileName: java_reflex_agent.java
 * @Description：
 * @Author: Jike Y
 * @email smile_yijie@163.com
 * @Datetime: 2022/6/16 下午1:22
 */

package com.ase;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class java_reflex_agent {
    public static void main(String[] args) {
        /*
        代理设计模式的核心:有真实业务实现类 代理业务实现类,完成比真实业务更多的处理操作
            传统弊端:基于接口的设计(必须)
                会产生耦合的问题,
                静态代理设计:一个代理类为一个接口服务
                动态代理设计:D:\Users\yijie\Java Project\Itellyou\material\picture\动态代理模式.png


         系统完成:
            创建代理对象:public static Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,
 InvocationHandler h)

        代理设计的方法:D:\Users\yijie\Java Project\Itellyou\material\picture\代理设计方法.png
         */


        /*
        CGLIB实现代理设计模式:基于类的代理设计

         */




    }

    /**
     * 代理方法调用,代理主题类里面执行的方法最终是此方法
     * @param proxy 要代理的对象
     * @param method 要执行的接口方法名称
     * @param args 传递的参数
     * @return 某一个方法的返回值
     * @throws Throwable 方法调用时出现的错误继续向上抛出
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
class Proxy implements InvocationHandler {
    private Object target;//真实业务处理对象

    /**
     * 进行真实业务对象与代理业务对象之间的绑定处理
     * @param target 真实业务对象
     * @return Proxy生成的代理业务对象
     */
    public Object bind(Object target){
        this.setTarget(target);
        return java.lang.reflect.Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行方法:" + method);
        Object returndata = null;
        if (this.connect()){
            returndata = method.invoke(this.target, args);
            this.close();
        }
        return returndata;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
    public boolean connect(){
        return true;
    }
    public void close(){}
}
//利用CGLIB实现代理设计
/*
class ProxyCGLIB implements MethodInterceptor{
    private Object target;//真实业务处理对象

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行方法:" + method);
        Object returndata = null;
        if (this.connect()){
            returndata = method.invoke(this.target, args);
            this.close();
        }
        return returndata;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
    public boolean connect(){
        return true;
    }
    public void close(){}



 */