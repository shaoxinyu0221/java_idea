package com.shaoxinyu.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author 邵鑫雨
 */
public class JdbcUtil {

    public static DataSource dataSource = null;

    /**
     * 创建连接对象方法
     * @return 返回一个链接对象
     */
    public static Connection getConnection(){
        if (dataSource == null){
            //1.创建properties对象，存储数据库信息
            Properties properties = new Properties();
            InputStream resourceAsStream = JdbcUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            try {
                properties.load(resourceAsStream);
                //2.创建德鲁伊连接池
                dataSource = DruidDataSourceFactory.createDataSource(properties);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //3.创建连接对象
        Connection connect = null;
        try {
            connect = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connect;
    }



    //关闭连接方法

    /**
     * 关闭连接方法
     * @param connect 连接对象
     * @param pst   sql预编译器
     * @param rs    结果集
     */
    public static void close(Connection connect, PreparedStatement pst, ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(pst != null){
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(connect != null){
            try {
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
