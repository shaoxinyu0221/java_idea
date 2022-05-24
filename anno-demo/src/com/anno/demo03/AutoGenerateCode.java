package com.anno.demo03;

import java.lang.reflect.Field;

public class AutoGenerateCode {

    public static void main(String[] args) {
        String sql = getCreateTableSQL("com.anno.demo03.Customer");
        System.out.println(sql);
    }

    public static String getCreateTableSQL(String className) {
        StringBuffer buffer = new StringBuffer("CREATE TABLE ");
        try {
            Class<?> aClass = Class.forName(className);
            if(!aClass.isAnnotationPresent(Table.class)){
                return null;
            }
            Table table = aClass.getDeclaredAnnotation(Table.class);
            buffer.append(table.value() + "(\r\n");
            //获取属性
            Field[] fields = aClass.getDeclaredFields();
            if (fields[0].isAnnotationPresent(Id.class)){
                Id id = fields[0].getDeclaredAnnotation(Id.class);
                if (id.autoIncrement()==true){
                    buffer.append(id.value() + " int" + " primary key auto_increment,\r\n");
                }else {
                    buffer.append(id.value() + " int" + " primary key,\r\n");
                }
            }
            for (int i=1;i<fields.length;i++){
                Field field = fields[i];
                if(!field.isAnnotationPresent(column.class)){
                    continue;
                }
                column column = field.getDeclaredAnnotation(column.class);
                if (i==fields.length-1){
                    buffer.append(column.value() + " " + column.columnType() + "\r\n");
                    break;
                }
                buffer.append(column.value() + " " + column.columnType() + ",\r\n");
            }
            buffer.append(");");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return buffer.toString();
    }

}
