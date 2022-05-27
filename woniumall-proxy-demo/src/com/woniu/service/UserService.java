package com.woniu.service;

import com.woniu.entity.User;

public interface UserService {

    void login(String account,String password);

    void register(User user);
}
