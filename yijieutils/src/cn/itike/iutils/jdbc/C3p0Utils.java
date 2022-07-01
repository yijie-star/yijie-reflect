package cn.itike.iutils.jdbc;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3p0Utils {
    //配置文件要求必须给出c3p0-config.xml！
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
    //事务专用连接
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
    /**
     * 使用连接池返回一个连接对象
     * @return
     * @throws SQLException
     */
    public static Connection getConnection () throws SQLException {
        Connection con = threadLocal.get();
        //当con不等于null，说明已经调用过beginTransaction()方法，表示开启了事务
        if (con != null) return con;

        return dataSource.getConnection();
    }

    public static DataSource getDataSources(){
        return dataSource;
    }

    /**
     * 开启事务
     * 1、获取一个Connection，设置它的setAutoCommit(false)
     * 2、保证dao中使用的连接刚刚创建的
     * -------------------
     * 1、创建一个Connection，设置为手动提交
     * 2、把这个Connection给dao用
     * 3、commitTransaction或者rollbackTransaction可以获取到
     */
    public static void beginTransaction() throws SQLException {
        Connection con = threadLocal.get();
        /**
         * 1、给connection赋值，设置为手动提交
         */
        if (con != null) throw new SQLException("已经开启了事务，就不要重复开启了！");
        con = getConnection();
        con.setAutoCommit(false);
        threadLocal.set(con);//当前前程的连接保存起来
    }

    /**
     * 提交事务
     * 1、获取beginTransaction提供的Connection，然后调用commit方法
     */
    public static void commitTransaction() throws SQLException {
        Connection con = threadLocal.get();//获取当前线程的专用连接
        /**
         * 1、直接使用connection.commit()
         */
        if (con != null) new SQLException("已经开启了事务，不要重复提交！");
        con.commit();
        con.close();
        threadLocal.remove();//从threadLocal中移除连接
    }

    /**
     * 1、获取beginTransaction提供的Connection，然后调用rollback方法
     */
    public static void rollbackTransaction() throws SQLException {
        Connection con = threadLocal.get();
        /**
         * 1、直接使用connection.rollback()
         */
        if (con == null) new SQLException("没有开启事务，不能回滚！");
        con.rollback();
        con.close();
        threadLocal.remove();
    }

    /**
     * 释放连接
     * @param connection
     */
    public static void releaseConnection(Connection connection) throws SQLException {
        Connection con = threadLocal.get();
        /**
         * 1、判断是否是事务专用，如果是，不用关闭，不是那么就要关闭
         * con == null,没有事务
         * con != connection不是事务，需要判断参数连接与con相等，不等即不是事务专用
         */
        if (con == null) connection.close();
        if (con != connection) connection.close();
    }
}
