package com.demo.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestJdkProxy {

    public static void main(String[] args) {
        RealStar realStar = new RealStar();
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("invoke方法被调用了" + method.getName());
                //用method调用方法,可以有返回值
                Object invoke = method.invoke(realStar, args);
                //下边方法的返回值
                return null;
            }
        };
        Star starProxy = (Star) Proxy.newProxyInstance(realStar.getClass().getClassLoader(),
                realStar.getClass().getInterfaces(),invocationHandler);

        String sing = starProxy.sing();
        System.out.println(sing);

    }
    
    
    
}
