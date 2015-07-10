package com.tw.core.dao;

import com.tw.core.entity.User;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

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

        session.delete(this.getUserById(id));

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

  public static void main(String[] args){
      System.out.print(new UserDao().getUserById(1));
  }
}
