package com.woniumall.test.service;

import com.woniumall.entity.User;
import com.woniumall.exception.MyServiceException;
import com.woniumall.service.UserService;
import com.woniumall.util.MyBatisUtil;
import org.junit.Test;

import java.util.Scanner;

public class UserServiceTest {

    @Test
    public void testLogin(){
        try {
            UserService userService = new UserService();
            User login = userService.login("admin", "12345");
        } catch (Exception e) {
            if(e instanceof MyServiceException){
                System.out.println(e.getMessage());
            }else {
                e.printStackTrace();
                System.out.println("登陆失败,系统维护中");
            }
        }
    }



    @Test
    public void testRegister(){
        Scanner input = new Scanner(System.in);
        UserService userService = new UserService();
        try {
            System.out.println("请输入账号");
            String account = input.next();
            User user = userService.queryUserByAccount(account);
            System.out.println("请输入密码");
            String password = input.next();
        } catch (Exception e) {
            if (e instanceof MyServiceException){
                System.out.println(e.getMessage());
            }else {
                e.printStackTrace();
                System.out.println("系统繁忙,请稍后重试");
            }

        }
    }


}
