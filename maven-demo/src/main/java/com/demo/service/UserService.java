package com.demo.service;

import com.demo.dao.UserDao;
import com.demo.entity.User;
import com.demo.exceptions.MyException;
import com.demo.util.MyBatisUtil;


import java.util.List;

public class UserService {

    /**
     * 登录方法
     * @param username
     * @param password
     * @return 如果登录成功返回一个用户对象
     */
    public User login(String username, String password) {
        UserDao userDao = MyBatisUtil.getSqlSession().getMapper(UserDao.class);
        User user = userDao.queryUserToLogin(username, password);
        if (user == null) {
            throw new MyException("用户名或密码错误");
        }else {
            return user;
        }
    }

    public static List<User> getUsers() {
        UserDao userDao = MyBatisUtil.getSqlSession().getMapper(UserDao.class);
        List<User> users = userDao.queryUserList();
        return users;
    }


    public void register(User user) {
        UserDao userDao = MyBatisUtil.getSqlSession().getMapper(UserDao.class);

        User user1 = userDao.queryUserByName(user.getUsername());
        if (user1 != null) {
            throw new MyException("用户名已存在");
        }
        Integer integer = userDao.registerUser(user);
        if (integer == 0){
            throw new MyException("注册失败");
        }


    }

}
