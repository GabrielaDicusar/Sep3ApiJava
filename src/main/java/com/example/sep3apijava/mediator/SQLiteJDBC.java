package com.example.sep3apijava.mediator;

import com.example.sep3apijava.api.model.User;
import com.example.sep3apijava.mediator.RegisterUserDB.RegisterUserDao;
import com.example.sep3apijava.mediator.RegisterUserDB.RegisterUserDaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class SQLiteJDBC {
    public static void main( String args[] ) {
        RegisterUserDao reg = new RegisterUserDaoImpl();
        System.out.println(reg.addUser(new User(1,"Kevin","KevinKevin")));
    }
}