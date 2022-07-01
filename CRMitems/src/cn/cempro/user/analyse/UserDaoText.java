package cn.cempro.user.analyse;


import cn.cempro.user.dao.CustomerDao;
import cn.cempro.user.dao.UserDao;
import cn.cempro.user.domain.Customer;
import cn.cempro.user.domain.User;
import org.junit.Test;

import java.sql.SQLException;

public class UserDaoText {
    @Test
    public void textFindByUsername(){
        UserDao userDao = new UserDao();
        User user = userDao.findBtUsername("wangwu");
        System.out.println(user);
    }
    @Test
    public void textAdd(){
        UserDao userDao = new UserDao();
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("4i");
        userDao.addUser(user);
    }
    @Test
    public void add() throws SQLException {
        CustomerDao customerDao = new CustomerDao();
        Customer customer = new Customer();
        customer.setCid("1");
        customer.setCname("sdf");
        customer.setGender("asfd");
        customer.setBirthday("444s");
        customer.setCellphone("546546");
        customer.setEmail("dfdvdsd");
        customer.setDescription("sdgsfs");
        customerDao.add(customer);
    }
}
