package com.demo.service;

import com.demo.util.MyBatisUtil;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ServiceProxyFactory {

    public static<T> T getProxy(T t){
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(t.getClass());

        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                T returnValue = null;
                try {
                    returnValue = (T) methodProxy.invokeSuper(proxy, args);
                    MyBatisUtil.getSqlSession().commit();
                } catch (Throwable e) {
                    MyBatisUtil.getSqlSession().rollback();
                    throw e;
                }finally {
                    MyBatisUtil.getSqlSession().close();
                }
                return returnValue;
            }
        });

        return (T) enhancer.create();
    }


}
