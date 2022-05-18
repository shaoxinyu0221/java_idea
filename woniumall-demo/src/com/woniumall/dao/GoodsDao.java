package com.woniumall.dao;

import com.woniumall.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDao {

    Integer add(Goods goods);


    Goods queryById(@Param("id") Integer id);


    List<Goods> queryAll();

    Integer update(Goods goods);

}
