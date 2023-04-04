package com.example.sep3apijava.api.controller;

import com.example.sep3apijava.api.model.User;
import com.example.sep3apijava.persistance.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user/")
public class UserController {

    UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<User> addNewUser(@RequestBody User user){
        boolean success = service.addUser(user);
        if(success){
            return new ResponseEntity<>(HttpStatus.OK);
        }else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
//
//    @GetMapping
//    public ResponseEntity<List<User>> getAllUsers(){
//        return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
//    }
//
//    @GetMapping("id/")
//    public ResponseEntity<User> getUserById(int id){
//        Optional<User> existing = service.getUserById(id);
//        if (existing.isPresent())
//            return new ResponseEntity<>(existing.get(), HttpStatus.OK);
//        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
}
