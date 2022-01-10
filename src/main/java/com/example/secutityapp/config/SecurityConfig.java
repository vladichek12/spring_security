package com.example.secutityapp.config;

import com.example.secutityapp.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
public class SecurityConfig {
    protected void configure(HttpSecurity http) throws Exception {
        http
                .exceptionHandling().accessDeniedPage("/access-denied")
                .and()
                .antMatcher("/registration.jsp")
                .authorizeRequests()
                .antMatchers("","/resources.jsp/**","/login.jsp").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login.jsp")
                .and()
                .logout();
    }
    public void configure(AuthenticationManagerBuilder auth) {
        try {
            auth.userDetailsService(userDetailsService());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }



}
