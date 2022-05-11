package com.shaoxinyu.service;

import com.shaoxinyu.dao.UserDao;
import com.shaoxinyu.entity.User;
import com.shaoxinyu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

public class UserService {

    Scanner input = new Scanner(System.in);
    @Test
    public void login(){
        System.out.println("输入账号");
        String username = input.next();
        System.out.println("输入密码");
        String password = input.next();

        boolean flag = false;
        //获取SQLSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //通过SQLSession创建接口的代理类对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //对象调方法
        ArrayList<User> list = userDao.queryAll();
        for(int i=0;i<list.size();i++){
            User user = list.get(i);
            if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
                flag = true;
                break;
            }else{
                flag = false;
            }
        }
        if (flag){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
    }


    public void register(){
        System.out.println("输入账号");
        String username = input.next();
        //查询账号是否存在
        boolean queryUsername = queryByUsername(username);
        if(!queryUsername){
            System.out.println("输入密码");
            String password = input.next();
            User user = new User(username,password);
            addUser(user);
            System.out.println("注册成功");
        }else{
            System.out.println("账号已经存在");
        }



    }

    public boolean queryByUsername(String username){
        boolean flag = false;
        //获取SQLSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //通过SQLSession创建接口的代理类对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //对象调方法
        User user = userDao.queryByUsername(username);
        System.out.println(user);
        if(user==null){
            flag = false;
        }else {
            flag = true;
        }
        return flag;
    }

    public void addUser(User user){
        //获取SQLSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //通过SQLSession创建接口的代理类对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //对象调方法
        userDao.add(user);
        //提交
        sqlSession.commit();
        //关闭
        sqlSession.close();
    }

}

class A{
    public static void main(String[] args) {
        UserService userService = new UserService();
        //userService.login();
        userService.register();
    }
}