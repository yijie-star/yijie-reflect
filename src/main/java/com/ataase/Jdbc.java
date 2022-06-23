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

        if (login.login(username, password) == true){
            System.out.println("\n登录成功");
        }else {
            System.out.println("\n用户名或密码错误！");
        }
















    }
    /*
    @Test
    public void testJdbc() {
        // 初始化数据
//        JdbcUtils.initData();
        try {
            // 1、创建DataSource实例
            DataSource dataSource = new UnpooledDataSource("org.hsqldb.jdbcDriver",
                    "jdbc:hsqldb:mem:mybatis", "sa", "");
            ///2、获取Connection对象
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from user");
            ///3、遍历ResultSet
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columCount = metaData.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columCount; i++) {
                    String columName = metaData.getColumnName(i);
                    String columVal = resultSet.getString(columName);
                    System.out.println(columName + ":" + columVal);
                }
                System.out.println("---------------------------------------");
            }
            ///4、关闭连接
            IOUtils.closeQuietly(statement);
            IOUtils.closeQuietly(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     */
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
        String sql = "select * from t_user where username = ? and password = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();//没有参数

        return resultSet.next();
    }

}