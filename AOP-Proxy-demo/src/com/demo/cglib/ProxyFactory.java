package com.demo.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory {

    public static<T> T getProxy(T t){
        //创建Enhancer对象
        Enhancer enhancer = new Enhancer();

        //设置代理对象的父类
        enhancer.setSuperclass(t.getClass());

        //设置方法回调,就是代理对象调方法时的一个统一的处理方式
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                //设置返回值
                T returnVal = null;
                try {
                    //铜鼓代理方法对象来直接调用proxy的父类的方法
                    returnVal = (T)methodProxy.invokeSuper(proxy, args);

                } catch (Exception e) {

                    e.printStackTrace();
                }
                return returnVal;
            }
        });

        return (T)enhancer.create();

    }

}
