package cn.itike.iutils.ademo;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QR<T> {
    private DataSource dataSource;

    public QR() {

    }

    public QR(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * insert,update,delete
     * @param sql
     * @param params
     * @return
     */
    public int update(String sql,Object...params){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            initParams(preparedStatement,params);
            return preparedStatement.executeUpdate();
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e1) {
                throw new RuntimeException(e1);
            }
        }
    }
    private void initParams(PreparedStatement preparedStatement,Object...parms) throws SQLException {
        for (int i = 0; i < parms.length; i++) {
            preparedStatement.setObject(i + 1,parms[i]);
        }
    }
    public T query(String sql,RsHander<T> rsHander,Object...params){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet res = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            initParams(preparedStatement,params);
            res = preparedStatement.executeQuery();
            return rsHander.handle(res);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e1) {
                throw new RuntimeException(e1);
            }
        }
    }
}
//将结果集转换为需要的类型!
interface RsHander<T> {
    public T handle(ResultSet resultSet) throws SQLException;
}