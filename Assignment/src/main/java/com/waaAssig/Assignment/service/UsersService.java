package com.waaAssig.Assignment.service;

import com.waaAssig.Assignment.domain.Comment;
import com.waaAssig.Assignment.domain.Post;
import com.waaAssig.Assignment.domain.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsersService {

    List<Users> findAllUsers();

    Users findUserById(Long id);

    void createUser(Users newUser);

    List<Post> findAllPosts(Long id);

    void addPostToUser(Long id, Post p);

    List<Users> findMoreThanOnePost(int n);

    List<Users> usersWithAPostTitled(String s);

    void deleteById(Long id);

    Post findUserByIdAndPost(Long userId, Long postId);

    Comment findCommentByUserAndPostId(Long uId, Long pId, Long cId);

    Users findUserByEmail(String email);
}
