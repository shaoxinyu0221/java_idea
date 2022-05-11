package com.shaoxinyu.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//Mybatis 工具类
public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory = null;

    /**
     * 获取SQLSession的方法
     * @return 返回一个SQLSession对象
     */
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        //1.获取配置文件
        try(InputStream input = Resources.getResourceAsStream("mybaties-config.xml");) {
            //2.创建builder对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //3.通过builder创建SQLSessionFactory
            if (sqlSessionFactory == null) {
                sqlSessionFactory = builder.build(input);
            }
            //4.通过sqlSessionFactory获取SQLSession
            sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sqlSession;
    }


    public static void closeSqlSession(SqlSession sqlSession){
        sqlSession.close();
    }
}
