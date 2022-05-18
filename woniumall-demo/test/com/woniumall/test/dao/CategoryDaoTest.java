package com.woniumall.test.dao;

import com.woniumall.dao.CategoryDao;
import com.woniumall.entity.Category;
import com.woniumall.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CategoryDaoTest {
    SqlSession sqlSession = null;
    CategoryDao categoryDao = null;

    @Before
    public void getUp(){
        sqlSession = MyBatisUtil.getSqlSession();
        categoryDao = sqlSession.getMapper(CategoryDao.class);
    }

    @After
    public void tearDown(){
        sqlSession.commit();
        MyBatisUtil.close(sqlSession);
    }

    @Test
    public void testInsert(){
        Category category = new Category("少儿读物", Category.NORMAL);
        Integer rows = categoryDao.insert(category);
        if(rows == 1){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
    }


    @Test
    public void delete(){
        Integer rows = categoryDao.delete(5);
        if(rows == 1){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }


    @Test
    public void update(){
        Category category = new Category(1,"奇幻文学", "1");
        Integer rows = categoryDao.update(category);
        if(rows == 1){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }


    @Test
    public void queryById(){

        Category category = categoryDao.queryById(1);
        System.out.println(category);

    }


    @Test
    public void queryAll(){
        for (Category category : categoryDao.queryAll()) {
            System.out.println(category);
        }
    }



}
