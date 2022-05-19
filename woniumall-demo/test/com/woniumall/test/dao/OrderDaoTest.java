package com.woniumall.test.dao;

import com.woniumall.dao.OrderDao;
import com.woniumall.entity.Order;
import com.woniumall.util.MallUtil;
import com.woniumall.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class OrderDaoTest {

    SqlSession sqlSession = null;
    OrderDao orderDao = null;

    @Before
    public void getUp(){
        sqlSession = MyBatisUtil.getSqlSession();
        orderDao = sqlSession.getMapper(OrderDao.class);
    }

    @After
    public void tearDown(){
        sqlSession.commit();
        MyBatisUtil.close(sqlSession);
    }

    @Test
    public void insert(){
        Order order = new Order();
        order.setNo("order0001");
        order.setUserid(1);
        order.setOrderTime(MallUtil.getNow());
        order.setPayType("0");
        order.setAccept("海绵宝宝");
        order.setTelephone("111222333444");
        order.setAddress("比奇堡");
        order.setTotalMoney(new BigDecimal("123.4"));
        order.setStatus("1");

        Integer insert = orderDao.insert(order);
        System.out.println(insert);
    }


    @Test
    public void queryListById(){
        Order byId = orderDao.getById(1);
        System.out.println(byId);
    }

}
