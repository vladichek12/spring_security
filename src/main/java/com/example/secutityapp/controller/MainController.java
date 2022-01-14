package com.example.secutityapp.controller;

import com.example.secutityapp.Entity.User;
import com.example.secutityapp.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class MainController {

    UserDetailsServiceImpl userService = new UserDetailsServiceImpl();

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String start(@ModelAttribute("user") User user, Model model) {
        GrantedAuthority auth = new SimpleGrantedAuthority("ROLE_ADMIN");
        if(userService.loadUserByUsername(user.getEmail())!=null)
        {
            if(userService.loadUserByUsername(user.getEmail()).getAuthorities().contains(auth))
                return "redirect:admin";
            else
                return "redirect:info";
        }
        else
            return "redirect:/";
    }

    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String admin(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "admin";
    }

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public String info(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "info";
    }

}
