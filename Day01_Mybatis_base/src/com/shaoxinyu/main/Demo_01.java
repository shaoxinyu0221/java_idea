package com.shaoxinyu.main;

import com.shaoxinyu.dao.UserDao;
import com.shaoxinyu.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Demo_01 {
    public static void main(String[] args) {
        //1.读取配置文件
        try {
            InputStream input = Resources.getResourceAsStream("mybaties-config.xml");
            //2.创建SQLSessionFactoryBuilder
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            //3.通过SQLSessionFactoryBuilder创建SQLSessionFactory
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(input);
            //4.通过sqlSessionFactory得到sqlsession
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //通过SQLSession创建UserDao对象
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            //通过对象调方法
            User user = new User("李杀神", "111111");
            userDao.add(user);
            //提交
            sqlSession.commit();
            System.out.println(user);
            //5.关闭sqlSession
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
