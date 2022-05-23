package com.woniu.test.service;

import com.woniu.entity.User;
import com.woniu.exception.MyServiceException;
import com.woniu.service.ServiceProxyFactory;
import com.woniu.service.UserService;
import com.woniu.serviceimpl.UserServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

public class TestUserService {

    @Test
    public void testLogin(){
        try {
            UserServiceImpl userService = new UserServiceImpl();
            UserService proxy = ServiceProxyFactory.getProxy(userService);
            proxy.login("admin", "123456");
            System.out.println("登录成功");
        } catch (Exception e) {
            Throwable cause = e.getCause();
            if(e.getCause().getCause() instanceof MyServiceException){
                System.out.println(cause.getCause().getMessage());
            }else{
                e.printStackTrace();
                System.out.println("系统繁忙,请稍后重试");
            }
        }
    }


    @Test
    public void testRegister(){
        User user = new User();
        user.setAccount("10000000");
        user.setRegTime("2000-01-01 12:00:00");
        user.setScore(0);
        user.setPassword("123456");
        user.setAvatar("img/avatar_01");
        user.setEmail("111@.com");
        user.setMoney(new BigDecimal("0"));
        user.setStatus(User.NORMAL);
        try {
            UserServiceImpl userService = new UserServiceImpl();
            UserService proxy = ServiceProxyFactory.getProxy(userService);
            proxy.register(user);
            System.out.println("注册成功");
        } catch (Exception e) {
            Throwable cause = e.getCause();
            if(e.getCause().getCause() instanceof MyServiceException){
                System.out.println(cause.getCause().getMessage());
            }else{
                e.printStackTrace();
                System.out.println("系统繁忙,请稍后重试");
            }
        }
    }


}
