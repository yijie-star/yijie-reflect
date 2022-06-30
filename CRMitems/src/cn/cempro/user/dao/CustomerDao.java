package cn.cempro.user.dao;

import cn.cempro.user.domain.Customer;
import cn.itike.iutils.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * 持久层
 */
public class CustomerDao {
    private QueryRunner qr = new TxQueryRunner();

    /**
     * 添加客户
     * @param customer
     */
    public void add(Customer customer) throws SQLException {
        String sql = "insert into customers values(?,?,?,?,?,?,?)";
        Object [] params = {customer.getCid(), customer.getCname(), customer.getGender(),
                customer.getBirthday(), customer.getCellphone(),
                customer.getEmail(), customer.getDescription()};
        qr.update(sql,params);
    }

}
