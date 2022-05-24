package com.woniu.service;

import com.woniu.exception.MyServiceException;
import com.woniu.serviceimpl.UserServiceImpl;
import com.woniu.util.MyBatisUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ServiceProxyFactory {

    public static<T> T getProxy(T t){
        Class<?>[] interfaces = t.getClass().getInterfaces();
        T proxy = (T) Proxy.newProxyInstance(t.getClass().getClassLoader(),
                interfaces,
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        try {
                            method.invoke(t,args);
                            MyBatisUtil.getSqlSession().commit();
                        } catch (Exception e) {
                            MyBatisUtil.getSqlSession().rollback();
                            if(e.getCause() instanceof MyServiceException){
                                System.out.println(e.getCause().getMessage());
                            }else {
                                e.printStackTrace();
                                System.out.println("服务器繁忙,请稍后重试");
                            }
                        }finally {
                            MyBatisUtil.getSqlSession().close();
                        }
                        return null;
                    }
                });

        return proxy;
    }

}
