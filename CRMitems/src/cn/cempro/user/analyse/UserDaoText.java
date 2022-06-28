package cn.cempro.user.analyse;


import cn.cempro.user.dao.UserDao;
import cn.cempro.user.domain.User;
import org.junit.Test;

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
}
