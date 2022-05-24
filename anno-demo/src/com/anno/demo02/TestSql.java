package com.anno.demo02;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestSql {


    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setUsername("赵日天");
        user.setPassword("123456");
        String sql = getSql(user);
        System.out.println(sql);
    }


    public static String getSql(Object obj){
        Class<?> aClass = obj.getClass();

        StringBuffer buffer = new StringBuffer("SELECT * FROM ");
        //获取表上的注解
        //如果没有注解,直接退出
        if(!aClass.isAnnotationPresent(Table.class)){
            return null;
        }
        Table table = aClass.getDeclaredAnnotation(Table.class);
        buffer.append(table.value());
        buffer.append(" WHERE 1=1 ");
        //获取属性值的注解
        for (Field field : aClass.getDeclaredFields()) {
            //如果当前属性没有注解,直接判断下一个属性有没有注解
            if(!field.isAnnotationPresent(Column.class)){
                continue;
            }
            Column column = field.getAnnotation(Column.class);
            buffer.append("and "+column.value()+"=");
            //设置get方法,获取属性值
            String methodName = "get" + field.getName().substring(0,1).toUpperCase() + field.getName().substring(1);
            //调用get方法获取属性值

            try {
                Method method = aClass.getMethod(methodName);
                Object invoke = method.invoke(obj);
                String columnName = invoke.toString();
                //拼接
                if (field.getType().getSimpleName().equals("String")){
                    buffer.append("'"+columnName+"'"+" ");
                }else {
                    buffer.append(columnName+" ");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return buffer.toString();
    }
}
