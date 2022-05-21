package com.employee.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {

    private static SqlSessionFactory factory = null;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();


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
     * 获取SQLSession
     * @return 返回一个SQLSession对象
     */
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = threadLocal.get();
        if(sqlSession == null){
            sqlSession = factory.openSession();
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }


    /**
     * 关闭连接对象
     * @param sqlSession 要关闭的SQLSession
     */
    public static void close(SqlSession sqlSession){
        if(sqlSession != null){
            sqlSession.close();
            threadLocal.remove();
        }
    }

}
