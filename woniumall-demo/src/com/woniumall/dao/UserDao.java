package com.woniumall.dao;

import com.woniumall.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    User queryUserToLogin(@Param("account") String account, @Param("password") String password);

    Integer insert(User user);


}
