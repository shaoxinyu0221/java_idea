package com.anno.demo04;

public class TestProxy {

    public static void main(String[] args) {
        User user = new User();
        user.setUsername("赵日天");
        user.setPassword("123456");


        UserService proxy = ProxyFactory.getProxy(new UserServiceImpl());
        Integer integer = proxy.addUser(user);
        System.out.println(integer);

    }


}
