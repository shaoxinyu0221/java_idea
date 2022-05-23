package com.woniu.dao;

import com.woniu.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    User queryUserByAccount(String account);


    User queryUserToLogin(@Param("account") String account, @Param("password") String password);


    Integer insertUserToReg(User user);

}
