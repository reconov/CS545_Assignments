package com.spring.assignmentOne.service;

import com.spring.assignmentOne.domain.Post;
import com.spring.assignmentOne.domain.Users;

import java.util.List;

public interface UsersService {

    List<Users> findAllUsers();

    Users findUserById(Long id);

    void createUser(Users newUser);

    List<Post> findAllPosts(Long id);

    void addPostToUser(Long id, Post p);

    List<Users> findMoreThanOnePost(int n);

    void deleteById(Long id);
}
