package com.product.service;

import com.product.dao.UserDao;
import com.product.entity.Cart;
import com.product.entity.User;
import com.product.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserService {

    @Test
    public void queryCartByUserName(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.queryCartByUserName("王诛魔");
        System.out.println("用户姓名\t年龄\t商品名称\t商品单价\t购买数量\t小计");
        for (Cart cart : user.getCartList()) {
            System.out.println(user.getUsername()+"\t"+user.getAge()+"\t"+cart.getpName()+"\t"+cart.getPrice()+cart.getNumber()+ cart.getAllPrice());
        }

        sqlSession.close();
    }

}
