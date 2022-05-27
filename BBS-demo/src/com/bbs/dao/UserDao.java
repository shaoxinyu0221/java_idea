package com.bbs.dao;

import com.bbs.entity.User;

import java.util.List;

public interface UserDao {

    Integer insert(User user);

    List<User> queryById();



}
