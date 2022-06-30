package cn.cempro.user.service;

import cn.cempro.user.dao.CustomerDao;
import cn.cempro.user.domain.Customer;

import java.sql.SQLException;

/**
 * 业务层
 */
public class CustomerService {
    private CustomerDao customerDao = new CustomerDao();

    /**
     * 添加客户
     * @param customer
     */
    public void add(Customer customer) throws SQLException {
        customerDao.add(customer);
    }
}
