package com.demo.servlet;

import com.demo.entity.User;
import com.demo.exceptions.MyException;
import com.demo.service.ServiceProxyFactory;
import com.demo.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //给user赋值
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setAge(Integer.parseInt(request.getParameter("age")));
        user.setSex(request.getParameter("sex"));
        //创建代理对象
        UserService proxy = ServiceProxyFactory.getProxy(new UserService());
        try {
            proxy.register(user);
            request.getRequestDispatcher("/RegisterSuccess.jsp").forward(request,response);
            System.out.println(user.getSex());
        } catch (Exception e) {
            if (e instanceof MyException){
                String message = e.getMessage();
                request.setAttribute("message",message);
                request.getRequestDispatcher("/register.jsp").forward(request,response);
            }else {
                e.printStackTrace();
            }
        }
    }
}
