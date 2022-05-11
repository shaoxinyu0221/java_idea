package com.shaoxinyu.main;

import com.shaoxinyu.dao.UserDao;
import com.shaoxinyu.entity.User;
import com.shaoxinyu.util.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Demo {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //5.通过sqlSession创建接口的代理对象
        UserDao userdao = sqlSession.getMapper(UserDao.class);
        //6.通过对象调方法
        User user = new User("赵日天","123456");
        Integer add = userdao.add(user);
        //7.提交事务
        sqlSession.commit();
        System.out.println("添加了"+add+"行");
        System.out.println(user);
        //8.关闭SQLSession
        MybatisUtil.closeSqlSession(sqlSession);
    }

}

class Test01{
    public static void main(String[] args) throws IOException {
        //读取配置文件
        InputStream input = Resources.getResourceAsStream("mybaties-config.xml");
        //创建builder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //创建SQLSessionFactory
        SqlSessionFactory sqlSessionFactory = builder.build(input);
        //用factory获取SQLSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserDao接口的代理类对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //对象调方法
        Integer row = userDao.add2("王诛魔", "12342234");
        Integer del = userDao.del("王诛魔");
        Integer update = userDao.update("wangwu","zhangsan");
        //提交
        sqlSession.commit();
        System.out.println(row);
        System.out.println(del);
        System.out.println(update);
        //关闭连接
        sqlSession.close();
    }
}
