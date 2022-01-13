package com.example.secutityapp.servlets;

import com.example.secutityapp.Entity.User;
import com.example.secutityapp.service.UserDetailsServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.util.Objects.hash;

@WebServlet(name = "registration", value = "/registration")
public class RegistrationServlet extends HttpServlet {
    //private UserRepositoryImpl repository = new UserRepositoryImpl();
    UserDetailsServiceImpl userDetailsService = new UserDetailsServiceImpl();

    public void init() {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setEmail(request.getParameter("email"));
        user.setId(hash(user)/13);
        //repository.save(user);
        userDetailsService.saveUser(user);
        response.sendRedirect("login.jsp");//poka chto
    }

    public void destroy() {
    }
}
