package com.example.sep3apijava.api.model;

import java.io.Serializable;
import java.util.List;

public class UserList implements Serializable {
    private List<User> userList;

    public UserList(List<User> userList) {
        this.userList = userList;
    }

    public void add (User user){
        userList.add(user);
    }
}
