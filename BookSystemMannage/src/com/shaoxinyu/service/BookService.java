package com.shaoxinyu.service;

import com.shaoxinyu.dao.BookDao;
import com.shaoxinyu.entity.Book;
import com.shaoxinyu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BookService {

    @Test
    public void queryAll(){
        //获取SQLSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //创建代理对象
        BookDao bookDao = sqlSession.getMapper(BookDao.class);
        //对象调方法
        List<Book> bookList = bookDao.queryAll();
        bookList.forEach(book -> {
            System.out.println(book);
        });
        //关闭SQLSession
        sqlSession.close();
    }
}
