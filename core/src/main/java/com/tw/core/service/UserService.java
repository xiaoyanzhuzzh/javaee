package com.tw.core.service;

import com.tw.core.entity.User;
import com.tw.core.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

//    @Autowired
    private UserDao userDao;

    @Autowired
    public  UserService(UserDao userDao) {
        this.userDao = userDao;
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

}