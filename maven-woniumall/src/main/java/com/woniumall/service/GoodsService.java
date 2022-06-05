package com.woniumall.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniumall.dao.GoodsDao;
import com.woniumall.entity.Goods;
import com.woniumall.util.MyBatisUtil;

import java.util.List;

public class GoodsService {

    public PageInfo<Goods> getGoodsInfo(Goods goods, Integer pageNumDefault, Integer pageSizeDefault) {
        //1.开启分页功能
        PageHelper.startPage(pageNumDefault, pageSizeDefault);
        //2.查询
        GoodsDao goodsDao = MyBatisUtil.getDao(GoodsDao.class);
        List<Goods> goodsList = goodsDao.queryGoodsByCondition(goods);
        //3.封装成pageInfo
        PageInfo<Goods> goodsInfo = new PageInfo(goodsList);

        return goodsInfo;
    }
}
