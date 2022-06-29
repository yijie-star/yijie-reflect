package cn.itike.iutils.jdbc;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 这个类中的方法，自己来处理连接问题
 * 无需外界传递
 * 怎么处理呢？
 *      通过JdbcPoolUtils.getConnection()得到连接，有可能是事务连接，也有可能是普通的连接
 *      JdbcPoolUtils.releaseConnection()，对连接的释放
 */
public class TxQueryRunner extends QueryRunner {

    @Override
    public int[] batch(String sql, Object[][] params) throws SQLException {
        /**
         * 1、得到连接
         * 2、执行父类方法,传递连接对象
         * 3、释放连接
         * 4、返回值
         */
        Connection con = JdbcPoolUtils.getConnection();
        int [] result = super.batch(con,sql,params);
        JdbcPoolUtils.releaseConnection(con);
        return result;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
        Connection con = JdbcPoolUtils.getConnection();
        T result = super.query(con,sql,params,rsh);
        JdbcPoolUtils.releaseConnection(con);
        return result;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
        Connection con = JdbcPoolUtils.getConnection();
        T result = super.query(con,sql,rsh);
        JdbcPoolUtils.releaseConnection(con);
        return result;
    }

    @Override
    public int update(String sql) throws SQLException {
        Connection con = JdbcPoolUtils.getConnection();
        int result = super.update(con,sql);
        JdbcPoolUtils.releaseConnection(con);
        return result;
    }

    @Override
    public int update(String sql, Object param) throws SQLException {
        Connection con = JdbcPoolUtils.getConnection();
        int result = super.update(con,sql,param);
        JdbcPoolUtils.releaseConnection(con);
        return result;
    }

    @Override
    public int update(String sql, Object... params) throws SQLException {
        Connection con = JdbcPoolUtils.getConnection();
        int result = super.update(con,sql,params);
        JdbcPoolUtils.releaseConnection(con);
        return result;
    }

    @Override
    public <T> T insert(String sql, ResultSetHandler<T> rsh) throws SQLException {
        return super.insert(sql, rsh);
    }

    @Override
    public <T> T insert(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
        return super.insert(sql, rsh, params);
    }

    @Override
    public <T> T insertBatch(String sql, ResultSetHandler<T> rsh, Object[][] params) throws SQLException {
        return super.insertBatch(sql, rsh, params);
    }

    @Override
    public int execute(String sql, Object... params) throws SQLException {
        return super.execute(sql, params);
    }

    @Override
    public <T> List<T> execute(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
        return super.execute(sql, rsh, params);
    }
}
