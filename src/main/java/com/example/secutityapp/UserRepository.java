package com.example.secutityapp;

import com.example.secutityapp.Entity.User;

import java.util.List;

public interface UserRepository{
    List<User> findAll();
    User findByEmail(String email);
    void save(User user);

}
