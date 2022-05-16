package com.shaoxinyu.service;

import com.shaoxinyu.dao.UserDao;
import com.shaoxinyu.entity.User;
import com.shaoxinyu.util.JdbcUtil;

import java.util.Map;

public class UserService {
    public static void main(String[] args) {
        User user = new User("赵日天","123456");
        User user02 = new User(2,"刘斩仙","345678");

        UserDao userDao = new UserDao();
//        boolean insert = userDao.insert(user02);
//        System.out.println(insert);
//        boolean update = userDao.update(user02);
//        System.out.println(update);
        for (User user1 : userDao.query()) {
            System.out.println(user1);
        }
//        for (Map<String, Object> stringObjectMap : userDao.queryMore()) {
//            System.out.println(stringObjectMap);
//        }


    }

}
