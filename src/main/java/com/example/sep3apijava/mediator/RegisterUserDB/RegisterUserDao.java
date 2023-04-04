package com.example.sep3apijava.mediator.RegisterUserDB;

import com.example.sep3apijava.api.model.User;
import com.example.sep3apijava.api.model.UserList;

import java.util.List;

public interface RegisterUserDao {
    boolean addUser(User user);
    User getUserByUsername(String username);
    UserList getAllUsers();

}
