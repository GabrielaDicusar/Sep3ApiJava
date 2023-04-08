package com.example.sep3apijava.mediator.RegisterUserDB;

import com.example.sep3apijava.mediator.model.User;
import com.example.sep3apijava.mediator.model.UserList;
import com.example.sep3apijava.mediator.DbConnection;

import java.sql.*;

public class RegisterUserDaoImpl implements RegisterUserDao{

    /**
     * This is a method that adds a new user and returns a boolean
     * @param user
     * @return true if user was created, false if username is taken
     */
    @Override
    public boolean addUser(User user) {
        try (Connection connection = DbConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * from user where username=?;");
            statement.setString(1, user.getUsername());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                connection.close();
                return false;
            } else {
                PreparedStatement statement2 = connection.prepareStatement("INSERT INTO user(id, \"username\",  \"password\") VALUES (?,?,?);");
                statement2.setInt(1, user.getId());
                statement2.setString(2, user.getUsername());
                statement2.setString(3, user.getPassword());
                statement2.executeUpdate();
                connection.close();


            }
        } catch (SQLException throwable) {

            throw new RuntimeException(throwable);
        }
        return true;
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public UserList getAllUsers() {
        return null;
    }



}

