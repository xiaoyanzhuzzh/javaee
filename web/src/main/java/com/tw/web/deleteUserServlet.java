package com.tw.web;

import com.tw.core.entity.User;
import com.tw.core.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeleteUserServlet extends HttpServlet{
    public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        int id = new Integer(req.getParameter("id"));

        System.out.print(id);
        Service service = new Service();
        service.deleteUserById(id);

        List<User> users = service.getUsers();
        req.setAttribute("users", users);
        req.getRequestDispatcher("index.jsp").forward(req, res);
    }

}
