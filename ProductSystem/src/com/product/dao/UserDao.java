package com.product.dao;

import com.product.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    User queryCartByUserName(@Param("username") String username);

}
