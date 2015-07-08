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
                        rs.getString("id"),
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
}
