package com.example.sep3apijava.mediator.RegisterUserDB;

import com.example.sep3apijava.api.model.User;
import com.example.sep3apijava.api.model.UserList;
import com.example.sep3apijava.mediator.DbConnection;

import java.sql.*;

public class RegisterUserDaoImpl implements RegisterUserDao{

    /**
     * This methods adds a new user and returns a boolean
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


//    @Override
//    public void addUser(User user) {
//        try (Connection connection = ConnectionDB.getConnection()) {
//            PreparedStatement statement = connection.prepareStatement("SELECT * from userr where username=?;");
//            statement.setString(1, user.getUsername());
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                connection.close();
//            } else {
//                PreparedStatement statement2 = connection.prepareStatement("INSERT INTO userr(\"firstname\", \"lastname\", \"username\", \"email\", \"smester\", \"type\", \"password\") VALUES (?,?,?,?,?,?,?);");
//                statement2.setString(1, user.getFirstName());
//                statement2.setString(2, user.getLastName());
//                statement2.setString(3, user.getUsername());
//                statement2.setString(4, user.getEmail());
//                statement2.setInt(5, user.getSemester());
//                statement2.setString(6, "tutoree");
//                statement2.setString(7, user.getPassword());
//                statement2.executeUpdate();
//                connection.close();
//
//
//            }
//        } catch (SQLException throwable) {
//
//            throw new RuntimeException(throwable);
//        }
//    }
//
//    @Override
//    public User getUserByUsername(String username) {
//        try (Connection connection = ConnectionDB.getConnection())
//        {
//            PreparedStatement statement = connection.prepareStatement("SELECT * FROM userr WHERE username=?;");
//            statement.setString(1, username);
//            ResultSet resultSet = statement.executeQuery();
//
//            if (resultSet.next())
//            {
//                String firstname = resultSet.getString("firstname");
//                String lastname = resultSet.getString("lastname");
//                String email = resultSet.getString("email");
//                String type = resultSet.getString("type");
//                String username1 = resultSet.getString("username");
//                String pass = resultSet.getString("password");
//                int semester = resultSet.getInt("semester");
//
//                connection.close();
//                return new User(type,username1,firstname,lastname,email,semester,pass);
//            }
//            else
//            {
//                connection.close();
//                return null;
//            }
//        }
//        catch (PSQLException e)
//        {
//            throw  new RuntimeException(e);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
//
//    @Override
//    public UserList getAllUsers() {
//        UserList temp = new UserList();
//        try (Connection connection = ConnectionDB.getConnection()) {
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from userr");
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            String type;
//            String username;
//            String firstName;
//            String lastName;
//            String email;
//            int semester;
//            String password;
//
//            while (resultSet.next()) {
//                type = resultSet.getString("type");
//                username = resultSet.getString("user_name");
//                firstName = resultSet.getString("first_name");
//                lastName = resultSet.getString("last_name");
//                lastName = resultSet.getString("last_name");
//                PreparedStatement statement2 = connection.prepareStatement("Select * from account where account_id = ?;");
//                statement2.setInt(1, resultSet.getInt("trainer_id"));
//                ResultSet resultSet1 = statement2.executeQuery();
//                if (resultSet1.next()) {
//                    trainer = new Account(resultSet1.getInt("account_type"), resultSet1.getString("firstname"), resultSet1.getString("lastname"), resultSet1.getString("email"), resultSet1.getString("phonenumber"), resultSet1.getString("username"), resultSet1.getString("password"));
//                    temp.addSession(new TrainingSession(type, time, participants, trainer, date));
//                } else {
//                    connection.close();
//                }
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return temp;
//    }


}

