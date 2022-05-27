package com.demo.servlet;

import com.demo.entity.User;
import com.demo.exceptions.MyException;
import com.demo.service.ServiceProxyFactory;
import com.demo.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class NewServelet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserService proxy = ServiceProxyFactory.getProxy(new UserService());
        try {
            User login = proxy.login(username, password);
            List<User> userList = proxy.getUsers();
            req.getRequestDispatcher("/LoginSuccess.jsp").forward(req, resp);
        } catch (Exception e) {
            if (e instanceof MyException) {
                String error = e.getMessage();
                req.setAttribute("error", error);
                req.getRequestDispatcher("").forward(req, resp);
            }else {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
