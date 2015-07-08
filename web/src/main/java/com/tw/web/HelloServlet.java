package com.tw.web;

import java.io.*;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.*;

import com.tw.core.entity.User;
import com.tw.core.service.Service;

public class HelloServlet extends HttpServlet {
    public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        PrintWriter out = res.getWriter();

        out.println(new Service().service());
        out.close();
    }

    public List<User> getUsers() {
        return new Service().getUsers();
    }
}