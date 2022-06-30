package cn.itike.iutils.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static Properties properties = null;
    //获取连接
    public static Connection getConnection(String path) throws SQLException {
        try {
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream(path);
            properties = new Properties();
            properties.load(inputStream);
            //加载驱动
            Class.forName(properties.getProperty("driverClassName"));
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        return DriverManager.getConnection(properties.getProperty("jdbcUrl"),
                properties.getProperty("username"),
                properties.getProperty("password"));
    }
}
