package com.exam.dao;

import com.exam.entity.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersDao {

    //1、使用关联查询，显示每个用户的信息及该用户拥有的所有帐号(一对多)【20分】
    Users getById(Integer id);

    List<Users> getByCondition(Users user);


    Integer addUerByForeach(List<Users> userList);

    Integer updateUserInfo(Users user);

    Integer deleteUserByForeach(Integer[] id);
}
