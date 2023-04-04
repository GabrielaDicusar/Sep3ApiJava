package com.example.sep3apijava.persistance;

import com.example.sep3apijava.api.model.User;
import com.example.sep3apijava.api.model.UserList;
import com.example.sep3apijava.mediator.RegisterUserDB.RegisterUserDao;
import com.example.sep3apijava.mediator.RegisterUserDB.RegisterUserDaoImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    RegisterUserDao registerUserDao;
    public UserService(List<User> users) {
        registerUserDao = new RegisterUserDaoImpl();
    }

    public boolean addUser(User user)
    {
     return registerUserDao.addUser(user);
    }

//    public List<User> getAllUsers(){
//        return users;
//    }
//
//    public Optional<User> getUserByUsername(String username){
//        Optional existing = Optional.empty();
//        for (User user: users) {
//            if(user.getUsername().equals(username))
//                existing = Optional.of(user);
//        }
//        return existing;
//    }
//
//    public void addUser(User user){
//        registerUserDao.addUser(user);
//        Optional<User> existing = getUserByUsername(user.getUsername());
//        if(existing.isPresent()){
//            return false;
//        }
//        else{
//            users.add(user);
//            return true;
//        }
//    }
//
//    public Optional<User> getUserById(long id){
//        Optional existing = Optional.empty();
//        for (User user: users) {
//            if(user.getId() == id)
//                existing = Optional.of(user);
//        }
//        return existing;
//    }
}
