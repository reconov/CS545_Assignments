package com.spring.assignmentOne.service;

import com.spring.assignmentOne.domain.Post;
import com.spring.assignmentOne.domain.Users;
import com.spring.assignmentOne.repo.PostRepo;
import com.spring.assignmentOne.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    UsersRepo usersRepo;

    @Autowired
    PostRepo postRepo;

    @Override
    public List<Users> findAllUsers() {
        return usersRepo.findAll();
    }

    @Override
    public Users findUserById(Long id) {
        return usersRepo.findById(id).orElse(null);
    }

    @Override
    public void createUser(Users newUser) {
        usersRepo.save(newUser);
    }

    @Override
    public List<Post> findAllPosts(Long id) {
        return postRepo.findAllById(id).orElse(null);
    }

    @Override
    public void addPostToUser(Long id, Post p) {
        // make sure the user by that id exists
        if(findUserById(id) != null) {
            System.out.println("Gathered data");
            System.out.println(id);
            System.out.println(p);
            System.out.println();

            p.setUser(findUserById(id));
            System.out.println("\n\n\n\n\nReached here");
            postRepo.save(p);
            System.out.println("\n\n\n\n\ndid i reach here? ");

//            System.out.println(usersRepo.findById(id).orElse(null).getPosts());
        }
    }
}
