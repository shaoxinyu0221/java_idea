package com.shaoxinyu.main;

import com.shaoxinyu.dao.UserDao;
import com.shaoxinyu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

public class Mybatis_CUD {

    public static void main(String[] args) {



    }

    /**
     * 增-insert
     */
    @Test
    public void testAdd(){
        //1.获取sqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //2.通过sqlSession创建接口对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //3.对象调方法
        Integer add2 = userDao.add2("1001", "123456");
        //4.提交
        sqlSession.commit();
        System.out.println("新增了"+add2+"行");
        //5.关闭
        MybatisUtil.closeSqlSession(sqlSession);
    }


    /**
     * 改-update
     */

    public void testUpdate(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        Integer update = userDao.update("wangwu", "zhangsan");
        sqlSession.commit();
        System.out.println(update);
        sqlSession.close();
    }


    /**
     * 删-delete
     */

    public void testDelete(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        Integer del = userDao.del("赵日天");
        sqlSession.commit();
        System.out.println(del);
        MybatisUtil.closeSqlSession(sqlSession);
    }

}
