package com.demo.cglib;

import org.junit.Test;

public class TestProxy {

    @Test
    public void testGetProxy(){
        try {
            RealStar proxy = ProxyFactory.getProxy(new RealStar());
            String sing = proxy.sing();
            System.out.println(sing);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
