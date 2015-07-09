package com.tw.web;

import com.tw.core.entity.User;
import com.tw.core.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUserServlet extends HttpServlet {

    public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        int id = new Integer(req.getParameter("id"));
        Service service = new Service();
        req.setAttribute("user", service.getUserById(id));

        req.getRequestDispatcher("updateUser.jsp").forward(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        int id = new Integer(req.getParameter("id"));
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");

        int age = new Integer(req.getParameter("age"));
        String email = req.getParameter("email");

        User user = new User(id,name,gender,age,email);
        new Service().updateUser(user);
        res.sendRedirect("/web/hello");
    }
}
