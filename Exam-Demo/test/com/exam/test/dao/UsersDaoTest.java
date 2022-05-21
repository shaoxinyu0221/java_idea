package com.exam.test.dao;

import com.exam.dao.UsersDao;
import com.exam.entity.AccountInfo;
import com.exam.entity.Users;
import com.exam.service.UsersService;
import com.exam.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class UsersDaoTest {

    SqlSession sqlSession = null;
    UsersDao usersDao = null;

    @Before
    public void getUp(){
        sqlSession = MyBatisUtil.getSqlSession();
        usersDao = sqlSession.getMapper(UsersDao.class);
    }

    @After
    public void tearDown(){
        sqlSession.commit();
        MyBatisUtil.close(sqlSession);
    }


    @Test
    public void testGetById(){
        Users user = usersDao.getById(1);
        System.out.println(user.getUsername()+"\t"+user.getSex()+"\t"+user.getAddress()+"\t"
                           +user.getMoney()+"\t"+user.getBirthday());
        for (AccountInfo accountInfo : user.getInfoList()) {
            System.out.println(accountInfo.getAccount()+"\t"+accountInfo.getPassword());
        }

    }

    @Test
    public void testGetByCondition(){
        Users users = new Users();
        users.setUsername("张");
        for (Users user : usersDao.getByCondition(users)) {
            System.out.println(user.getUsername()+"\t"+user.getSex()+"\t"+user.getAddress()+"\t"
                    +user.getMoney()+"\t"+user.getBirthday());
            for (AccountInfo accountInfo : user.getInfoList()) {
                System.out.println(accountInfo.getAccount()+"\t"+accountInfo.getPassword());
            }
            System.out.println("==========================");
        }

    }

    @Test
    public void testAddUser(){
        AccountInfo info = new AccountInfo();
        info.setAccount("admin");
        info.setPassword("1234");

        Users user01 = new Users();
        user01.setUsername("泰罗奥特曼");
        user01.setSex("男");
        user01.setAddress("M78星云光之国");
        user01.setMoney(0.0);
        user01.setBirthday("1973-04-06 08:00:00");


        Users user02 = new Users();
        user02.setUsername("艾斯奥特曼");
        user02.setSex("男");
        user02.setAddress("M78星云光之国");
        user02.setMoney(0.0);
        user02.setBirthday("1972-04-07 08:00:00");

        Users user03 = new Users();
        user03.setUsername("赛文奥特曼");
        user03.setSex("男");
        user03.setAddress("M78星云光之国");
        user03.setMoney(0.0);
        user03.setBirthday("1967-10-01 08:00:00");

        List<Users> usersList = Arrays.asList(user01, user02, user03);

        UsersService usersService = new UsersService();
        //usersService.addUser(usersList,info);
        Integer integer = usersDao.addUerByForeach(usersList);
        if(integer>0){
            System.out.println("添加成功");
            System.out.println("受影响的行数为" + integer);
        }else {
            System.out.println("添加失败");
        }
    }


    @Test
    public void testUpdate(){
        Users user = new Users();
        user.setId(1);
        user.setUsername("杰克奥特曼");
        user.setSex("男");
        user.setAddress("M78星云光之国");
        user.setMoney(0.0);
        user.setBirthday("1971-04-02 08:00:00");
        Integer integer = usersDao.updateUserInfo(user);
        System.out.println(integer);
    }


    @Test
    public void testDelete(){
        Integer[] arr = new Integer[]{15,16,17};
        Integer integer = usersDao.deleteUserByForeach(arr);
        System.out.println(integer);
    }


}
