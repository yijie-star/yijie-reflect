/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: java_IO_case_6.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

public class java_IO_case_6 {
    public static void main(String[] args) {
        /*
        完成系统登录程序，从命令行输入用户名和密码，如果没有输入用户名和密码，则提示，
        如果输入用户名没有输入密码，提示输入密码，然后判断用户名是否为mldn,密码是否是hello，如果正确，则提示登录成功
        否则登录失败，用户再次输入，连续三次系统退出
         */
    }
}
//1、定义一个用户服务接口
interface IUserService{
    boolean isExit();//是否需要退出
    boolean login(String name,String password);
}
//2、实现子类
class UserServiceImpl implements IUserService{

    private int count = 0;//登录统计

    @Override
    public boolean isExit() {
        return this.count >= 3;//登录退出的条件
    }

    @Override
    public boolean login(String name, String password) {
        this.count ++;
        return "mldn".equals(name) && "hello".equals(password);
    }
}
//3、对于登录失败的检测处理操作，应该单独定义一个用户的检测操作类
class UserSeiviceProxy implements IUserService {
    private IUserService userService;

    public UserSeiviceProxy(IUserService userService) {
        this.setUserService(userService);
    }

    @Override
    public boolean isExit() {
        return this.userService.isExit();
    }

    @Override
    public boolean login(String name, String password) {
        while (!this.isExit()) {//不进行退出
            String inputData = InputUtil.getString("请输入登录信息：");
            if (inputData.contains("/")) {//用户名和密码以/分割
                String temp[] = inputData.split("/");//数据拆分
                if (this.userService.login(temp[0], temp[1])) {//登录验证
                    return true;
                } else {
                    System.out.println("登录失败，错误的用户名或密码！");
                }
            } else {//只用用户名
                String pwd = InputUtil.getString("请输入密码：");
                if (inputData.contains("/")) {//用户名和密码以/分割
                    String temp[] = inputData.split("/");//数据拆分
                    if (this.userService.login(inputData, pwd)) {//登录验证
                        return true;
                    } else {
                        System.out.println("登录失败，错误的用户名或密码！");
                    }
                }
            }
        }
        return false;
    }

    public IUserService getUserService () {
        return userService;
    }

    public void setUserService (IUserService userService){
            this.userService = userService;
    }
}
//4、工厂类定义
class UserFactory{
    public static IUserService getInstance(){
        return new UserSeiviceProxy(new UserServiceImpl());
    }
}
//定义测试类

/*
真实业务只实现核心功能，辅助逻辑处理交给代理控制
 */