package com.tw.core.dao;

import com.tw.core.DbConnect;
import com.tw.core.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    DbConnect dbConnect  = new DbConnect();
    private PreparedStatement prepareStatement = null;
    private ResultSet rs = null;

    public User getUserById(int id) {
        User user = null;
        String sql = "SELECT * FROM users WHERE id = '"+id+"'";
        Connection connection = dbConnect.getConnection();
        Statement statement = null;
        ResultSet rs = null;

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            rs.next();

            user = new User(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("gender"),
                    rs.getInt("age"),
                    rs.getString("email")
            );

            rs.close();
            statement.close();
            dbConnect.closeConnection();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> getUsers(){
        List<User> users = new ArrayList<User>();

        String sql = "SELECT * FROM users";
        Connection connection = dbConnect.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while(rs.next()){
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getInt("age"),
                        rs.getString("email")
                ));
            }
            rs.close();
            statement.close();
            dbConnect.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void createUser(User user){

        Connection connection = dbConnect.getConnection();
        String sql = "insert into users(name, gender, age, email) values(?, ?, ?, ?)";
        try {
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, user.getName());
            prepareStatement.setString(2, user.getGender());
            prepareStatement.setInt(3, user.getAge());
            prepareStatement.setString(4, user.getEmail());

            System.out.println(prepareStatement);

            int rows = prepareStatement.executeUpdate();
            if(rows > 0) {
                System.out.println("插入成功!");
            } else {
                System.out.println("插入失败");
            }
            prepareStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUserById(int id){
        String sql = "delete from users where id = '"+id+"'";
        Connection connection = dbConnect.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            int result = statement.executeUpdate(sql);
            if(result > 0){
                System.out.println("删除成功");
            }
            else{
                System.out.println("删除失败");
            }
            statement.close();
            dbConnect.closeConnection();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user){

        String sql = "update users set name = '"+user.getName()+"', gender = '"+user.getGender()
                +"',age = "+user.getAge()+" ,email = '"+user.getEmail()
                +"' where id = "+user.getId()+"";
        Connection connection = dbConnect.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            int result = statement.executeUpdate(sql);
            if(result > 0){
                System.out.println("更新成功");
            }
            else{
                System.out.println("更新失败");
            }
            statement.close();
            dbConnect.closeConnection();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
