package com.tw.core.service;

import com.tw.core.entity.User;
import com.tw.core.dao.UserDao;

import java.util.List;

public class Service {
    public UserDao userDao = new UserDao();

    public String service() {
        return "Hello World";
    }

    public User getUserById(int id) {

        return userDao.getUserById(id);
    }

    public List<User> getUsers() {

        return userDao.getUsers();
    }

    public void createUser(User user) {

        userDao.createUser(user);
    }

    public void deleteUserById(int id) {

        userDao.deleteUserById(id);
    }

    public void updateUser(User user) {

        userDao.updateUser(user);
    }


    public static void main(String[] args) {
        System.out.print(new Service().getUsers());
    }
}