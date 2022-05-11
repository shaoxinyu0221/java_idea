package com.shaoxinyu.dao;

import com.shaoxinyu.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao {

    /**
     * 查询所有图书
     * @return 返回一个集合
     */
    List<Book> queryAll();

    //添加书籍

    /**
     * 添加书籍
     * @param book 要添加的书籍对象
     * @return 返回受影响的行数
     */
    Integer insertBook(Book book);

    /**
     * 通过id查询书籍信息
     * @param id 要查询的书籍id
     * @return 返回一个book对象
     */
    Book queryById(@Param("id") Integer id);

    /**
     * 通过id修改书籍信息
     * @param id 要修改的书籍id
     * @return 返回受影响的行数
     */
    Integer updateBook(@Param("bookName")String bookName,@Param("bookDesp")String bookDesp,@Param("bookPrice")Double bookPrice,@Param("id") Integer id);


    /**
     * 删除书籍
     * @param id 要删除的书籍id
     * @return 返回受影响的行数
     */
    Integer deleteBook(@Param("id") Integer id);
}
