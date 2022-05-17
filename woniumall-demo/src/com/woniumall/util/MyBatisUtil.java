package com.woniumall.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {

    private static SqlSessionFactory factory = null;

    static {
        try {
            InputStream input = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            factory = builder.build(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取SQLSession对象
     * @return 返回一个SQLSession对象
     */
    public static SqlSession getSqlSession(){
        return factory.openSession();
    }


    /**
     * 关闭SQLSession
     * @param sqlSession要关闭的SQLSession对象
     */
    public static void close(SqlSession sqlSession){
        if(sqlSession != null){
            sqlSession.close();
        }
    }

}
