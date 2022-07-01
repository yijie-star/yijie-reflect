package cn.cempro.user.service;

import cn.cempro.user.dao.UserDao;
import cn.cempro.user.domain.User;

import java.sql.SQLException;

/**
 * User的业务逻辑层
 */
public class UserService {
    private UserDao userDao = new UserDao();

    /**
     * 注册功能
     * @param user
     * @throws UserException
     */
    public void regist(User user) throws UserException, SQLException {
        /**
         * 1、使用用户名去查询，如果返回null，完成添加
         * 2、若不是null，抛出异常
         */
        User _user = userDao.findBtUsername(user.getUsername());
        if (_user != null){
            throw new UserException("用户名" + user.getUsername() + "已被注册！");
        }
        userDao.add(user);
    }

    /**
     * 登录功能
     * @param form
     * @return
     */
    public User login(User form) throws UserException {
        /**
         * 1、使用form中的username进行查询得到User user
         * 2、如果返回为null，说明用户名存在，抛出异常
         * 3、比较user的password和form中的password，不同抛出异常
         * 4、返回数据库中查询出来的user，而不是form，因为form中还有用户名和密码，而user是所有用户信息
         */
        User user = userDao.findBtUsername(form.getUsername());
        if (user == null) {
            throw new UserException("用户名不存在！");
        }
        if (!form.getPassword().equals(user.getPassword())){
            throw new UserException("用户名或密码错误！");
        }
        return user;
    }
}
