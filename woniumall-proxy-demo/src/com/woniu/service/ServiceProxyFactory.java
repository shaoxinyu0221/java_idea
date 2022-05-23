package com.woniu.service;

import com.woniu.serviceimpl.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ServiceProxyFactory {

    public static<T> UserService getProxy(T t){
        Class<?>[] interfaces = t.getClass().getInterfaces();
        UserService proxy = (UserService) Proxy.newProxyInstance(t.getClass().getClassLoader(),
                interfaces,
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        method.invoke(t,args);
                        return null;
                    }
                });

        return proxy;
    }

}
