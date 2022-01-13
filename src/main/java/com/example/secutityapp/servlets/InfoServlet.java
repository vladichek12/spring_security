package com.example.secutityapp.servlets;

import com.example.secutityapp.Entity.User;
import com.example.secutityapp.service.UserDetailsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "info", value = "/info")
public class InfoServlet extends HttpServlet {
    //private UserRepositoryImpl repository = new UserRepositoryImpl();
    UserDetailsServiceImpl userDetailsService = new UserDetailsServiceImpl();

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<User> users = new ArrayList<>();
        users = userDetailsService.findAll();
        request.setAttribute("users",users);
        request.getServletContext().getRequestDispatcher("/info.jsp").forward(request,response);

    }

    public void destroy() {
    }
}
