package com.woniumall.web;

import com.github.pagehelper.PageInfo;
import com.woniumall.entity.Category;
import com.woniumall.entity.Goods;
import com.woniumall.service.CategoryService;
import com.woniumall.service.GoodsService;
import com.woniumall.service.ServiceProxyFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/manage/goods")
public class GoodsServlet extends HttpServlet {

    private GoodsService goodsService = ServiceProxyFactory.getProxy(new GoodsService());
    private CategoryService categoryService = ServiceProxyFactory.getProxy(new CategoryService());
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String opr = request.getParameter("opr");
        if ("queryGoodsList".equals(opr)){
            queryGoodsList(request, response);
        }else if ("gotoAddGoods".equals(opr)){
            gotoAddGoods(request, response);
        }
    }


    /**跳转到商品添加页面*/
    protected void gotoAddGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/goods_add.jsp").forward(request, response);
    }

    /**商品信息管理*/
    protected void queryGoodsList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //获取搜索框内的元素
        String goodName = request.getParameter("goodName");
        Integer categoryId = null;
        String goodTypeId = request.getParameter("goodTypeId");
        if (goodTypeId != null && !"".equals(goodTypeId)){
            categoryId = Integer.parseInt(goodTypeId);
        }
        //条件回显
        request.setAttribute("goodName",goodName);
        request.setAttribute("goodTypeId",goodTypeId);
        //封装成对象
        Goods goods = new Goods();
        goods.setName(goodName);
        goods.setCategoryId(categoryId);
        //设置分页,默认从第一页开始
        Integer pageNumDefault = 1;
        String pageNum = request.getParameter("pageNum");
        if (pageNum!=null && !"".equals(pageNum)){
            pageNumDefault = Integer.parseInt(pageNum);
        }
        //设置默认显示行,默认显示5行
        Integer pageSizeDefault = 5;
        String pageSize = request.getParameter("pageSize");
        if (pageSize!=null && !"".equals(pageSize)){
            pageSizeDefault = Integer.parseInt(pageSize);
        }
        PageInfo<Goods> goodsInfo = goodsService.getGoodsInfo(goods, pageNumDefault, pageSizeDefault);
        request.setAttribute("goodsInfo",goodsInfo);
        //查询商品类型表
        List<Category> categoryList = categoryService.getCategoryList();
        request.setAttribute("categoryList",categoryList);


        request.getRequestDispatcher("/goods_list.jsp").forward(request,response);
    }

}
