package com.example.secutityapp.servlets;

import com.example.secutityapp.Entity.User;
import com.example.secutityapp.UserRepositoryImpl;
import com.example.secutityapp.config.SecurityConfig;
import com.example.secutityapp.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import static java.util.Objects.hash;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {
    //private UserRepositoryImpl repository = new UserRepositoryImpl();
    @Autowired
    SecurityConfig config;
    UserDetailsService userDetailsService = config.userDetailsService();

    public void init() {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setEmail(request.getParameter("email"));
        user.setId(hash(user) / 13);
        if (userDetailsService.loadUserByUsername(user.getEmail())!=null){
            response.sendRedirect("resources");//poka chto
        }

        else{
            response.sendRedirect("login.jsp");
        }

    }

    public void destroy() {
    }
}