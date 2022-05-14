package com.product.service;

import com.product.dao.ProductDao;
import com.product.entity.Product;
import com.product.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


public class ProductService {

    /**
     * 根据id删除商品信息
     */
    @Test
    public void deleteProduct(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        ProductDao productDao = sqlSession.getMapper(ProductDao.class);
        Integer row = productDao.deleteProduct(1);
        sqlSession.commit();
        if (row==1){
            System.out.println("删除成功");
        }else {
            System.out.println("要删除的商品信息不存在");
        }
        sqlSession.close();
    }


    @Test
    public void queryUserByPName(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        ProductDao productDao = sqlSession.getMapper(ProductDao.class);
        Product product = productDao.queryUserByPName("充电器");
        System.out.println(product);
        sqlSession.close();
    }


}
