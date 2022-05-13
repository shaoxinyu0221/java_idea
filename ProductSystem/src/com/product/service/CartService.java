package com.product.service;

import com.product.dao.CartDao;
import com.product.entity.Cart;
import com.product.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CartService {

    @Test
    /**
     * 给2号用户添加3条购物车信息
     */
    public void insertCartForUser2(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        CartDao cartDao = sqlSession.getMapper(CartDao.class);
        //创建对象
        Cart cart1 = new Cart(2,1,1,30.0);
        Cart cart2 = new Cart(2,2,3,6.0);
        Cart cart3 = new Cart(2,4,3,15.0);
        List<Cart> list = new ArrayList<Cart>();
        list.add(cart1);
        list.add(cart2);
        list.add(cart3);
        list.forEach(cart -> {
            cartDao.insertCartForUser2(cart);
        });
        sqlSession.commit();
        System.out.println("添加成功");
        sqlSession.close();
    }

}
