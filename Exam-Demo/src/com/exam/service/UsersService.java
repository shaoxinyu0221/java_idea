package com.exam.service;

import com.exam.dao.AccountInfoDao;
import com.exam.dao.UsersDao;
import com.exam.entity.AccountInfo;
import com.exam.entity.Users;
import com.exam.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UsersService {

    public void addUser(List<Users> userList, AccountInfo account){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UsersDao usersDao = sqlSession.getMapper(UsersDao.class);
        AccountInfoDao infoDao = sqlSession.getMapper(AccountInfoDao.class);

        //向user表中添加数据


    }



}
