package com.woniumall.dao;

import com.woniumall.entity.Order;

public interface OrderDao {

    Integer insert(Order order);

    Order getById(Integer id);

}
