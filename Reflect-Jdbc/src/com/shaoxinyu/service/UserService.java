package com.shaoxinyu.service;

import com.shaoxinyu.dao.UserDao;
import com.shaoxinyu.entity.User;
import com.shaoxinyu.util.JdbcUtil;

import java.util.List;
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
        List<User> query = userDao.query();
        query.forEach(e -> {
            System.out.println(e);
        });
//        for (Map<String, Object> stringObjectMap : userDao.queryMore()) {
//            System.out.println(stringObjectMap);
//        }


    }

}
