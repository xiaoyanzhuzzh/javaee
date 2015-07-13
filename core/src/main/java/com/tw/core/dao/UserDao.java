package com.tw.core.dao;

import com.tw.core.entity.User;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserDao {

    public User getUserById(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        User user= (User) session.get(User.class, id);
        session.close();
        return user;
    }

    public List<User> getUsers(){

        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> users = session.createQuery("from User").list();

        session.close();
        return users;
    }

    public void createUser(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteUserById(int id){

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        User user = (User) session.load(User.class, id);
        session.delete(user);

        session.getTransaction().commit();
        session.close();
    }

    public void updateUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    public Boolean verifyUserInfo(String name, String password) {
        Boolean result = false;
        Session session = HibernateUtil.getSessionFactory().openSession();

        String hql = "from User where name=? and password=?";
        Query query = session.createQuery(hql);

        query.setString(0, name);
        query.setString(1, password);

        List<User> users = query.list();
        if(users.size() == 1) {
            result = true;
        }
        session.close();

        return result;
    }

//    public static void main(String[] args) {
//        Boolean result = new UserDao().verifyUserInfo("张志慧", "123456");
//    }
}
