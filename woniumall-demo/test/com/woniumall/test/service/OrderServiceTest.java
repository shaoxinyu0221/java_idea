package com.woniumall.test.service;

import com.woniumall.entity.Order;
import com.woniumall.entity.OrderItem;
import com.woniumall.service.OrderService;
import com.woniumall.service.UserService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class OrderServiceTest {

    /**
     * 测试生成订单的业务逻辑
     */
    @Test
    public void testInsertOrder(){
        OrderService orderService = new OrderService();

        //创建订单对象模拟传参
        Order order = new Order();
        order.setUserid(1);
        order.setPayType(Order.ZFB);
        order.setAccept("蟹老板");
        order.setTelephone("13323456789");
        order.setAddress("比奇堡");

        OrderItem item1 = new OrderItem();
        item1.setGoodsId(1);
        item1.setNum(2);

        OrderItem item2 = new OrderItem();
        item2.setGoodsId(2);
        item2.setNum(3);

        List<OrderItem> orderItems = Arrays.asList(item1, item2);

        //调用业务层代码
        orderService.add(order,orderItems);

    }


}
