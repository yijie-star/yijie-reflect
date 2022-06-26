
package cn.book.sql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    public static Connection getConnection() throws IOException, SQLException, ClassNotFoundException {
        /*
        1、加载配置文件
        2、加载驱动，自动注册加载
        3、调用DriverManager.getConnection
         */
        InputStream inputStream = JdbcUtils.class.getClassLoader()
                .getResourceAsStream("dbconfig.properties");
        Properties properties = new Properties();
        properties.load(inputStream);//获取每一行数据

        //Class.forName(properties.getProperty("driverClassName"));
        return DriverManager.getConnection
                (properties.getProperty("jdbcUrl"),
                        properties.getProperty("userName"),
                        properties.getProperty("password"));//通过key获取数据并连接数据库

    }

//    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
//        Connection connection = JdbcUtils.getDataSource();
//        System.out.println(connection);
//    }


}
