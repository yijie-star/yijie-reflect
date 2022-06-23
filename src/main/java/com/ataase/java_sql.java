package com.ataase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class java_sql {
    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/yijie?characterEncoding=utf8&useSSL=false";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "yijie";
    public static void main(String[] args) throws Exception {
        /*
        sql执行器: 利用Statement接口来完成
        定义: public interface Statement extends Wrapper, AutoCloseable
        获取Statement接口对象,依靠connection提供的方法完成:

            问题: 文档操作
                1 不能很好的描述出日期的形式
                2 需要进行SQL语句的拼凑处理,编写和维护困难
                3 对于敏感的字符数据,无法进行合理的拼凑

            解决办法:
                public interface PreparedStatement extends Statement
            依然需要connection接口实现:
                PreparedStatement prepareStatement(String sql基础) throws SQLException
                数据库更新: int executeUpdate() throws SQLException
                数据库查询: ResultSet executeQuery() throws SQLException
                SQL之中要设置"?"作为占位符(比如说条件,需要用到,并且要进行设置)


            Statement createStatement() throws SQLException(最大异常)

            数据更新处理: int executeUpdate(String sql基础) throws SQLException
            数据查询处理: ResultSet executeQuery(String sql基础) throws SQLException
         */
        Connection connection = null ;//每一个Connection接口对象描述的就是一个用户连接
        //Class.forName(DATABASE_DRIVER);//加载驱动,此步骤不需要系统或自动注册
        connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        Statement statement = connection.createStatement();//创建数据库对象
        /*
        {//插入数据的操作
            String sql_1 = "insert into realization(uid, title, readx, price, content) values\n" +
                    "                                (1,'语文',100,99.6,'小何'),\n" +
                    "                                (2,'数学',200,85.0,'我爱你'),\n" +
                    "                                (3,'英语',100,25.2,'你是云彩');";
            int count = statement.executeUpdate(sql_1);//返回影响的行数
            System.out.println("插入了" + count + "行数据!");
        }

         */
        /*
        {//更新数据的操作
            String sql_2 = "update realization set title = '体育',price = '520.1' where uid = '3'";
            int count = statement.executeUpdate(sql_2);
            System.out.println("更新了" + count + "行数据!");
        }

         */
        /*
        {//删除数据的操作
            String sql_3 = "DELETE FROM realization where uid = '2'";
            int count = statement.executeUpdate(sql_3);
            System.out.println("影响了" + count + "行数据!");
        }

         */
        /*
        数据的查询:
            public interface ResultSet extends Wrapper, AutoCloseable
         */
        /*
        {//数据查询
            String sql_4 = "select uid, title, readx, price, content from realization;";
            ResultSet resultSet = statement.executeQuery(sql_4);//执行查询
            while (resultSet.next()){//有数据未输出
                int uid = resultSet.getInt(1);
                String title = resultSet.getString(2);
                int readx = resultSet.getInt(3);
                double price = resultSet.getDouble(4);
                String content = resultSet.getString(5);
                System.out.println(uid + "," + title + "," + readx + "," + price + "," + content);
            }

        }
         */
        connection.close();

    }
}
