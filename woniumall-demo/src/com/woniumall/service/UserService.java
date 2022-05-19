package com.woniumall.service;

import com.woniumall.dao.UserDao;
import com.woniumall.entity.User;
import com.woniumall.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Scanner;

public class UserService {

    Scanner input = new Scanner(System.in);

    public static Integer userId = null;

    public boolean login(){
        boolean flag = false;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        System.out.println("请输入账号");
        String account = input.next();
        System.out.println("请输入密码");
        String password = input.next();
        User user = userDao.queryUserToLogin(account, password);
        if(user == null){
            flag = false;
        }else {
            flag = true;
            userId = user.getId();
        }
        sqlSession.close();
        return flag;
    }


}
