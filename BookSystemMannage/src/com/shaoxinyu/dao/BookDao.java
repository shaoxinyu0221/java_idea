package com.shaoxinyu.dao;

import com.shaoxinyu.entity.Book;

import java.util.List;

public interface BookDao {

    /**
     * 查询所有图书
     * @return 返回一个集合
     */
    List<Book> queryAll();

}
