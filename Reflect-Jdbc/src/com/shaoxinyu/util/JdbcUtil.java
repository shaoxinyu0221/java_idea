package com.shaoxinyu.util;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;

public class JdbcUtil {

    private static String url;
    private static String driverClass;
    private static String username;
    private static String password;

    static{
        Properties properties = new Properties();
        try(InputStream input = JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties");) {
            properties.load(input);
            //读取配置文件中的属性
            url = properties.getProperty("url");
            driverClass = properties.getProperty("driverClass");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("配置文件读取失败");
        }

    }

    /**
     * 获取连接对象
     * @return 返回一个连接对象
     */
    public static Connection getConnection(){
        //加载驱动
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("驱动加载失败");
        }

        //获取连接对象
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("驱动加载失败");
        }
        return connection;
    }

    /**
     * 关闭连接
     * @param connect 连接对象
     * @param pst 预编译器
     * @param rs 结果集
     */
    public static void closeAll(Connection connect, PreparedStatement pst, ResultSet rs){
        try {
            if(rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (pst != null){
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    if(connect != null){
                        connect.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public static void main(String[] args) {
        Connection connection = getConnection();
        System.out.println(connection);
        closeAll(connection, null, null);
    }


    public static int executeUpdate(String sql, Object...params){
        Connection connect = getConnection();
        PreparedStatement pst = null;
        try {
            pst = connect.prepareStatement(sql);

            for(int i=0;i<params.length;i++){
                pst.setObject(i+1, params[i]);
            }

            int rows = pst.executeUpdate();
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JdbcUtil.closeAll(connect, pst, null);
        }
        return 0;
    }

    /**
     * 查询
     * @param sql 查询语句
     * @param clazz 返回值对象,用来存储查询到的数据
     * @param params 动态sql的值
     * @param <T> 泛型
     * @return  返回一个包含查询结果的集合
     */
    public static<T> List<T> executeQuery(String sql, Class<T> clazz, Object...params){
        List<T> list = new ArrayList<>();
        Connection connect = getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = connect.prepareStatement(sql);
            for(int i=0;i<params.length;i++){
                pst.setObject(i+1, params[i]);
            }
            rs = pst.executeQuery();
            while (rs.next()){
                try {
                    //创建一个对象存储数据
                    T t = clazz.newInstance();
                    //获取对象的属性

                    //根据属性名进行查询
                     for(int i=0;i<rs.getMetaData().getColumnCount();i++){
                        String setField = "set"+rs.getMetaData().getColumnLabel(i).substring(0,1).toUpperCase()+rs.getMetaData().getColumnLabel(i).substring(1);
                        Field field = clazz.getDeclaredField(rs.getMetaData().getColumnLabel(i));
                        Method declaredMethodSet = clazz.getDeclaredMethod(setField, field.getType());
                        declaredMethodSet.invoke(t,setField);
                    }


                    //向数组中添加对象
                    list.add(t);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(connect, pst, rs);
        }
        return null;
    }


    //多表关联查询
    public static List<Map<String,Object>> executeQueryForMulti(String sql, Object...params){
        List<Map<String,Object>> list = new ArrayList<>();
        Connection connect = getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = connect.prepareStatement(sql);
            for(int i=0;i<params.length;i++){
                pst.setObject(i+1, params[i]);
            }
            rs = pst.executeQuery();
            while(rs.next()){
                Map<String,Object> map = new HashMap<>();
                for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
                    map.put(rs.getMetaData().getColumnName(i), rs.getObject(i));
                }
                list.add(map);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(connect, pst, rs);
        }
        return null;
    }


}
