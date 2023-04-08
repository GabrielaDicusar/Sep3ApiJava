package com.example.sep3apijava.mediator;

import com.example.sep3apijava.mediator.model.User;
import com.example.sep3apijava.mediator.RegisterUserDB.RegisterUserDao;
import com.example.sep3apijava.mediator.RegisterUserDB.RegisterUserDaoImpl;

public class SQLiteJDBC {
    public static void main( String args[] ) {
        RegisterUserDao reg = new RegisterUserDaoImpl();
        System.out.println(reg.addUser(new User(1,"Kevin","KevinKevin")));
    }
}