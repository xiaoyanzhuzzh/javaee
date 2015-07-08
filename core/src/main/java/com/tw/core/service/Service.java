package com.tw.core.service;

import com.tw.core.entity.User;
import com.tw.core.dao.UserDao;

import java.util.List;

public class Service {
    public String service() {
        return "Hello World";
    }

    public List<User> getUsers() {

        UserDao userDao = new UserDao();
        return userDao.getUsers();
    }

    public static void main(String[] args) {
        System.out.print(new Service().getUsers());
    }
}