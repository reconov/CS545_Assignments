package com.spring.assignmentOne.controller;


import com.spring.assignmentOne.domain.Post;
import com.spring.assignmentOne.domain.Users;
import com.spring.assignmentOne.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public List<Users> findAllUsers(){
        return usersService.findAllUsers();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Users findUsersById(@PathVariable("id") Long id){
        return usersService.findUserById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public void saveNewUser(@RequestBody Users newUser){
        usersService.createUser(newUser);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/posts")
    public List<Post> findAllUsersPosts(@PathVariable("id") Long id){
        return usersService.findAllPosts(id);
    }

}
