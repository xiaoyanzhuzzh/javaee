package com.tw.web;

import java.io.*;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.*;

import com.tw.core.entity.User;
import com.tw.core.service.UserService;

public class HelloServlet extends HttpServlet {
    public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
System.out.print("=========");
        UserService service = new UserService();
        List<User> users = service.getUsers();
        req.setAttribute("users", users);
        req.getRequestDispatcher("index.jsp").forward(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");

        int age = new Integer(req.getParameter("age"));
        String email = req.getParameter("email");

        User user = new User(name,gender,age,email);
        new UserService().createUser(user);
        res.sendRedirect("/web/hello");
    }
}