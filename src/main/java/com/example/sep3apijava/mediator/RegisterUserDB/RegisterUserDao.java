package com.example.sep3apijava.mediator.RegisterUserDB;

import com.example.sep3apijava.mediator.model.User;
import com.example.sep3apijava.mediator.model.UserList;

public interface RegisterUserDao {
    boolean addUser(User user);
    User getUserByUsername(String username);
    UserList getAllUsers();

}
