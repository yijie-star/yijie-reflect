package com.ataase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Jdbc {


    public static void main(String[] args) throws Exception {
        /*
        jdbc：java数据库连接
            四大参数：
                driverClassName：com.mysql.jdbc.Driver
                URL：jdbc:mysql://localhost:3306/数据库名
                username：
                password：

           代码规范化：使用try-catch-finally处理
         */

        /*
        PreparedStatement prepareStatement(String sql基础) throws SQLException
                数据库更新: int executeUpdate() throws SQLException
                数据库查询: ResultSet executeQuery() throws SQLException
                SQL之中要设置"?"作为占位符(比如说条件,需要用到,并且要进行设置)


         */

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String username = scanner.next();
        System.out.print("请输入密码：");
        String password = scanner.next();

        if (login.login(username, password) == true) {
            System.out.println("\n登录成功");
        } else {
            System.out.println("\n用户名或密码错误！");
        }


    }
}
class login {
    /*
    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/yijie?characterEncoding=utf8&useSSL=false";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "yijie";

     */
    /**
     * 简单的登录程序
     *
     * @param username 登录的用户名
     * @param password 登录的密码
     * @return 返回登录成功或者用户名或密码错误
     */
    public static boolean login(String username, String password) throws SQLException, IOException, ClassNotFoundException {
        /*
        Class.forName("com.mysql.jdbc.Driver");通过SPI自动注册

        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        String sql = "select * from t_user where username = '" + username + "' and password = '" + password + "'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);


         */
        Connection connection = null;
        connection = JdbcUtils.getConnection("src/dbconfig.properties");
        String sql = "select * from t_user where username = ? and password = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();//没有参数

        return resultSet.next();
    }

}