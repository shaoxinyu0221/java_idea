package com.bbs.util;

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
        try(InputStream input = Resources.getResourceAsStream("mybatis-config.xml");) {
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            factory = builder.build(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取一个SQLSession对象
     * @return 返回一个sqlsession
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
     * 关闭SQLSession
     * @param sqlSession 要关闭的sqlsession对象
     */
    public static void close(SqlSession sqlSession){
        if(sqlSession != null){
            sqlSession.close();
            threadLocal.remove();
        }
    }

}
