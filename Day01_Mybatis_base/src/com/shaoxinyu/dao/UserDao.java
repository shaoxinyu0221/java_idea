package com.shaoxinyu.dao;

import com.shaoxinyu.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface UserDao {
    Integer add(User user);

    Integer add2(@Param("name") String name, @Param("password") String password);

    Integer del(@Param("name") String name);

    Integer update(@Param("oldName") String oldName,@Param("newName") String newName);

    /**
     * 通过id查询,查询单行
     * @param id 要查询的id
     * @return 返回一个对象
     */
    User queryById(@Param("id") Integer id);

    /**
     * 查询所有
     * @return 返回一个集合
     */
    ArrayList<User> queryAll();
}
