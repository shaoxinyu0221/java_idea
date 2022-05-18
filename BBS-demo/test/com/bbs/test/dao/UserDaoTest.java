package com.bbs.test.dao;

import com.bbs.dao.UserDao;
import com.bbs.entity.User;
import com.bbs.util.BBSUtil;
import com.bbs.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserDaoTest {

    SqlSession sqlSession = null;

    UserDao userDao = null;

    @Before
    public void getUp(){
        sqlSession = MyBatisUtil.getSqlSession();
        userDao = sqlSession.getMapper(UserDao.class);
    }
    @After
    public void tearDown(){
        sqlSession.commit();
        MyBatisUtil.close(sqlSession);
    }



    @Test
    public void insert(){
        User user = new User();
        user.setAccount("1003");
        user.setPassword("123456");
        user.setNickname("蟹老板");
        user.setEmail("1003@user.com");
        user.setScore(0);
        user.setAvatar("img/avatar_04");
        user.setTopicnums(10);
        user.setReplaynums(40);
        user.setRegtime(BBSUtil.getNow());
        user.setRole("3");

        Integer insert = userDao.insert(user);
        System.out.println(insert);

    }

    @Test
    public void getById(){
        User user = userDao.queryById(1);
        System.out.println(user);
    }

}
