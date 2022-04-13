package com.waaAssig.Assignment.controller;


import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/")
public class indexControllerTest {

    @GetMapping("/admin")
    public String adminView(){
        System.out.println("Admin controller");
        return ("<h1> Welcome to Admin </h1>");
    }

    @GetMapping("/users")
    public String usersView(){
        System.out.println("User Controller");
        return ("<h1> Welcome to Users </h1>");
    }

    @GetMapping()
    public String homeView(){
        Collection<SimpleGrantedAuthority> authorities
                = (Collection<SimpleGrantedAuthority>)
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        System.out.println("authorities = " + authorities);
        return ("<h1> Welcome to Home page </h1>");
    }

}
