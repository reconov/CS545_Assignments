package com.spring.assignmentOne.service;

import com.spring.assignmentOne.domain.Comment;
import com.spring.assignmentOne.domain.Post;
import com.spring.assignmentOne.domain.Users;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("javainuse".equals(username)) {
            return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }