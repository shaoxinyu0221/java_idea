package com.woniumall.test.dao;

import com.woniumall.dao.CategoryDao;
import com.woniumall.entity.Category;
import com.woniumall.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class CategoryDaoTest {


    @Test
    public void testInsert(){
        Category category = new Category("国学经典", "0");

        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        CategoryDao categoryDao = sqlSession.getMapper(CategoryDao.class);
        Integer rows = categoryDao.insert(category);
        sqlSession.commit();
        if(rows == 1){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
        MyBatisUtil.close(sqlSession);
    }


    @Test
    public void delete(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        CategoryDao categoryDao = sqlSession.getMapper(CategoryDao.class);
        Integer rows = categoryDao.delete(5);
        sqlSession.commit();
        if(rows == 1){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
        MyBatisUtil.close(sqlSession);
    }


    @Test
    public void update(){
        Category category = new Category(1,"奇幻文学", "1");
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        CategoryDao categoryDao = sqlSession.getMapper(CategoryDao.class);
        Integer rows = categoryDao.update(category);
        sqlSession.commit();
        if(rows == 1){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
        MyBatisUtil.close(sqlSession);
    }


    @Test
    public void queryById(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        CategoryDao categoryDao = sqlSession.getMapper(CategoryDao.class);
        Category category = categoryDao.queryById(1);
        System.out.println(category);
        MyBatisUtil.close(sqlSession);
    }


    @Test
    public void queryAll(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        CategoryDao categoryDao = sqlSession.getMapper(CategoryDao.class);
        for (Category category : categoryDao.queryAll()) {
            System.out.println(category);
        }

        MyBatisUtil.close(sqlSession);
    }



}
