package com.tw.core.service;

import com.tw.core.dao.AdminDao;
import com.tw.core.entity.Admin;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminDao adminDao;
    public Boolean verifyAdminInfo(String name, String password) {
        return adminDao.verifyAdminInfo(name, password);
    }
}
