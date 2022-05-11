package com.shaoxinyu.main;

import com.shaoxinyu.dao.UserDao;
import com.shaoxinyu.entity.User;
import com.shaoxinyu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;

public class MyBatisSelect {
    public static void main(String[] args) {
        //查询单行
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.queryById(1);
        System.out.println(user);
        //查询不需要提交
        sqlSession.close();
    }
}


/**
 * 查询多行
 */
class QueryAll{
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        ArrayList<User> list = userDao.queryAll();
        list.forEach(e -> {
            System.out.println(e);
        });
        //查询不需要提交
        sqlSession.close();

    }
}
