package com.example.secutityapp.service;

import com.example.secutityapp.Entity.User;
import com.example.secutityapp.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepositoryImpl repository = new UserRepositoryImpl();
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = repository.findByEmail(s);
        List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        if(user.getEmail().equals("adm!n"))
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        org.springframework.security.core.userdetails.User userDetails
                = new org.springframework.security.core.userdetails.User(user.getName(), user.getEmail(), grantedAuthorities);
        return userDetails;
    }
    public void saveUser(User user){
        repository.save(user);
    }

    public List<User> findAll(){
        List<User> users = repository.findAll();
        return users;
    }
}
