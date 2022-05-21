package com.exam.test.dao;

import com.exam.dao.AccountInfoDao;
import com.exam.dao.UsersDao;
import com.exam.entity.AccountInfo;
import com.exam.entity.Users;
import com.exam.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AccountInfoTest {

    SqlSession sqlSession = null;
    AccountInfoDao accountDao = null;

    @Before
    public void getUp(){
        sqlSession = MyBatisUtil.getSqlSession();
        accountDao = sqlSession.getMapper(AccountInfoDao.class);
    }

    @After
    public void tearDown(){
        sqlSession.commit();
        MyBatisUtil.close(sqlSession);
    }


    @Test
    public void testGetById(){
        AccountInfo account = accountDao.getById(1);
        System.out.println("序号\t账号\t密码\t用户姓名\t性别\t地址\t余额\t生日");
        System.out.print(account.getId()+"\t"+account.getAccount()+"\t"+account.getPassword());
        Users user = account.getUser();
        System.out.println(user.getUsername()+"\t"+user.getSex()+"\t"+user.getAddress()+"\t"+
                           user.getMoney()+"\t"+user.getBirthday());
    }
}
