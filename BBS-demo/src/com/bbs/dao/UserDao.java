package com.bbs.dao;

import com.bbs.entity.User;

public interface UserDao {

    Integer insert(User user);

    User queryById(Integer id);

}
