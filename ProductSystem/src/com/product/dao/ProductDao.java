package com.product.dao;

import com.product.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDao {

    /**
     * 根据商品id删除商品信息
     * @param id 要删除的商品id
     * @return 返回受影响的行数
     */
    Integer deleteProduct(@Param("id") Integer id);

//    List<Product> queryUserByPName(@Param("pName") String pName);

    Product queryUserByPName(@Param("pName") String pName);
}
