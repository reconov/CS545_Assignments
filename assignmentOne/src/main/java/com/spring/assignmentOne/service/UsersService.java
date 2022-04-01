package com.spring.assignmentOne.service;

import com.spring.assignmentOne.domain.Post;
import com.spring.assignmentOne.domain.Users;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UsersService {

    List<Users> findAllUsers();

    Users findUserById(Long id);

    void createUser(Users newUser);

    List<Post> findAllPosts(Long id);

}
