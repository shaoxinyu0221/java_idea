package com.demo.staticproxy;

public class TestProxy {

    public static void main(String[] args) {
        //创建真实明星对象
        RealStar realStar = new RealStar();
        //创建代理对象
        StarProxy starProxy = new StarProxy(realStar);

        realStar.sing();
        System.out.println("===================");
        starProxy.sing();
    }
}
