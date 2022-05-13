package com.product.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {

    private static SqlSessionFactory factory = null;

    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        try(InputStream input = Resources.getResourceAsStream("mybatis-config.xml");) {
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            if(factory == null){
                factory = builder.build(input);
            }
            sqlSession = factory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
}
