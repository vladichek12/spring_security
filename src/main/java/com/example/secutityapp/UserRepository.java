package com.example.secutityapp;

import com.example.secutityapp.Entity.User;

import java.util.List;

public interface UserRepository{
    List<User> findAll();
    boolean findByEmail(User user);
    void save(User user);

}
