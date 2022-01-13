package com.example.secutityapp.servlets;

import com.example.secutityapp.Entity.User;
import com.example.secutityapp.service.UserDetailsServiceImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import static java.util.Objects.hash;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {
    //private UserRepositoryImpl repository = new UserRepositoryImpl();
    UserDetailsServiceImpl userDetailsService = new UserDetailsServiceImpl();

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
            response.sendRedirect("login.jsp");
        }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setEmail(request.getParameter("email"));
        user.setId(hash(user) / 13);
        List<User> users = new ArrayList<>();
        users = userDetailsService.findAll();
        request.setAttribute("users",users);
        try {
            GrantedAuthority auth = new SimpleGrantedAuthority("ROLE_ADMIN");
            if(userDetailsService.loadUserByUsername(user.getEmail())!=null)
            {
                if(userDetailsService.loadUserByUsername(user.getEmail()).getAuthorities().contains(auth))
                    request.getServletContext().getRequestDispatcher("/admin.jsp").forward(request,response);
                else
                    request.getServletContext().getRequestDispatcher("/info.jsp").forward(request,response);
            }
            else
                response.sendRedirect("login.jsp");
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }

    public void destroy() {
    }
}