package com.anno.demo04;

import com.anno.util.MyBatisUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    public static<T> T getProxy(T t){

        T proxy = (T)Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object invoke = null;
                        try {
                            invoke = method.invoke(t, args);
                            //提交
                            MyBatisUtil.getSqlSession().commit();
                        } catch (Exception e) {
                            //回滚
                            MyBatisUtil.getSqlSession().close();
                            throw e.getCause();
                        } finally {
                            //关闭
                            MyBatisUtil.getSqlSession().close();
                        }
                        return invoke;
                    }
                });
        if (!t.getClass().isAnnotationPresent(Transactional.class)){
            return t;
        }
        return proxy;
    }


}
