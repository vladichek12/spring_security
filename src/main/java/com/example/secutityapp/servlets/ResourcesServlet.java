package com.example.secutityapp.servlets;

import com.example.secutityapp.Entity.User;
import com.example.secutityapp.UserRepositoryImpl;
import com.example.secutityapp.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.hash;

@WebServlet(name = "resources", value = "/resources")
public class ResourcesServlet extends HttpServlet {
    //private UserRepositoryImpl repository = new UserRepositoryImpl();
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<User> users = new ArrayList<>();
        users = userDetailsService.findAll();
       request.setAttribute("users",users);
        request.getServletContext().getRequestDispatcher("/resources.jsp").forward(request,response);

    }

    public void destroy() {
    }
}
