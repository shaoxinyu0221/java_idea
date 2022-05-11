package com.shaoxinyu.main;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Demo_02 {
    public static void main(String[] args) throws IOException {
        //1.获取配置文件
        InputStream input = Resources.getResourceAsStream("mybaties-config.xml");
        //2.创建SqlSessionFactory的创建者
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.通过builder创建SQLSessionFactory
        SqlSessionFactory sqlSessionFactory = builder.build(input);
        //4.通过sqlSessionFactory获取SQLSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        System.out.println(sqlSession);
        //5.关闭SQLSession
        sqlSession.close();
    }
}
