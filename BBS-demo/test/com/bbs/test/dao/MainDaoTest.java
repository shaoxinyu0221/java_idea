package com.bbs.test.dao;

import com.bbs.dao.MainDao;
import com.bbs.dao.UserDao;
import com.bbs.entity.Main;
import com.bbs.entity.User;
import com.bbs.util.BBSUtil;
import com.bbs.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MainDaoTest {

    SqlSession sqlSession = null;

    MainDao mainDao = null;

    @Before
    public void getUp(){
        sqlSession = MyBatisUtil.getSqlSession();
        mainDao = sqlSession.getMapper(MainDao.class);
    }
    @After
    public void tearDown(){
        sqlSession.commit();
        MyBatisUtil.close(sqlSession);
    }


    @Test
    public void getTopicList(){
        for (Main main : mainDao.getTopicList()) {
            System.out.println(main);
        }

    }

    @Test
    public void testQueryByCondition(){
        List<Main> mainList = mainDao.queryByCondition(null, "海绵宝宝", null, null, null);
        for (Main main : mainList) {
            System.out.println(main.getTitle());
        }
    }


}
