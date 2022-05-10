package com.shaoxinyu.dao;

import com.shaoxinyu.entity.User;
import com.shaoxinyu.util.JdbcUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookJdbc {

    /**
     * 向表中添加数据
     * @return 返回受影响的行数,如果为0,添加失败
     */
    public int add(){
        int row = 0;
        //1.连接数据库
        Connection connect = JdbcUtil.getConnection();
        //2.写sql语句
        String sql = "insert into t_user(username, password) values (?,?)";
        //3.sql预编译
        PreparedStatement pst = null;
        try {
            pst = connect.prepareStatement(sql);
            //4.给动态sql赋值
            pst.setString(1, "1001");
            pst.setString(2, "123456");
            //执行
            row = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭连接
            JdbcUtil.close(connect, pst, null);
        }

        return row;
    }


    public int delete(){
        int row = 0;
        //1.连接数据库
        Connection connect = JdbcUtil.getConnection();
        //2.写sql语句
        String sql = "delete from t_user where username='1001';";
        //3.sql预编译
        PreparedStatement pst = null;
        try {
            pst = connect.prepareStatement(sql);
            //4.执行sql语句
            row = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭连接
            JdbcUtil.close(connect, pst, null);
        }
        return row;
    }


    public int update(){
        int row = 0;
        //1.连接数据库
        Connection connect = JdbcUtil.getConnection();
        //2.写sql
        String sql = "update t_user set username=? where username=?";
        //3.sql预编译
        PreparedStatement pst = null;
        try {
            pst = connect.prepareStatement(sql);
            //4.给动态sql赋值
            pst.setString(1, "zhangsan");
            pst.setString(2, "wangwu");
            //5.执行sql
            row = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(connect, pst, null);
        }
        return row;
    }


    public List<User> query(){
        List<User> list = new ArrayList<User>();
        //1.连接数据库
        Connection connect = JdbcUtil.getConnection();
        //写sql语句
        String sql = "select username from t_user";
        //预编译
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = connect.prepareStatement(sql);
            //执行
            rs = pst.executeQuery();
            //遍历
            while (rs.next()){
                //创建对象存储接收到的信息
                User user = new User();
                user.setUsername(rs.getString("username"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(connect, pst, rs);
        }

        return list;
    }
}
