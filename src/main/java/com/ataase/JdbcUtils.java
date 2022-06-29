
package com.ataase;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    public static Connection getConnection(String path) throws IOException, SQLException, ClassNotFoundException {
        /*
        1、加载配置文件
        2、加载驱动，自动注册加载
        3、调用DriverManager.getgetConnection
         */
        InputStream inputStream = JdbcUtils.class.getClassLoader()
                .getResourceAsStream(path);
        Properties properties = new Properties();
        properties.load(inputStream);//获取每一行数据
        Class.forName(properties.getProperty("driverClassName"));
        return DriverManager.getConnection
                (properties.getProperty("jdbcUrl"),
                        properties.getProperty("username"),
                        properties.getProperty("password"));//通过key获取数据并连接数据库

    }
}
