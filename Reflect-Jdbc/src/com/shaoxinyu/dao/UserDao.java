package com.shaoxinyu.dao;

import com.shaoxinyu.entity.User;
import com.shaoxinyu.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UserDao {

//    public boolean insert(User user){
//
//        String sql = "insert into user(username, password) values(?,?)";
//
//        Connection connect = JdbcUtil.getConnection();
//        PreparedStatement pst = null;
//        try {
//            pst = connect.prepareStatement(sql);
//            pst.setString(1, user.getUsername());
//            pst.setString(2, user.getPassword());
//
//            int rows = pst.executeUpdate();
//            if(rows != 0){
//                return true;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally{
//            JdbcUtil.closeAll(connect, pst, null);
//        }
//        return false;
//    }

    public boolean insert(User user){
        String sql = "insert into user(username, password) values(?,?)";
        int i = JdbcUtil.executeUpdate(sql, user.getUsername(), user.getPassword());
        return i > 0;
    }


    public boolean delete(Integer id){
        String sql = "delete from user where id=?";
        int i = JdbcUtil.executeUpdate(sql, id);
        return i > 0;
    }

    public boolean update(User user){
        String sql = "update user set username=?, password=? where id=?";
        int i = JdbcUtil.executeUpdate(sql, user.getUsername(), user.getPassword(),user.getId());
        return i > 0;
    }

    public List<User> query(){
        String sql = "select username from user";
        return JdbcUtil.executeQuery(sql, User.class);
    }


    public List<Map<String, Object>> queryMore(){
        String sql = "select * from user,cart where user.id=cart.cid";
        return JdbcUtil.executeQueryForMulti(sql);
    }

}
