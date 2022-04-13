package com.waaAssig.Assignment.controller;


import com.waaAssig.Assignment.aspect.logger.ExcutionTime;
import com.waaAssig.Assignment.domain.Comment;
import com.waaAssig.Assignment.domain.Post;
import com.waaAssig.Assignment.domain.Users;
import com.waaAssig.Assignment.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping()
    public String index(){
        return ("<h1>Welcome to Users endpoint</h1>");
    }

//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("/")
//    public List<Users> findAllUsers(){
//        return usersService.findAllUsers();
//    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    @ExcutionTime
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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{userId}/posts/{postId}/")
    public Post findPostByUserAndPostId(@PathVariable("userId") Long userId,
                                    @PathVariable("postId") Long postId){
        return usersService.findUserByIdAndPost(userId, postId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{userId}/posts/{postId}/comments/{commentId}")
    public Comment findCommentByUserAndPostId(@PathVariable("userId") Long userId,
                                              @PathVariable("postId") Long postId,
                                              @PathVariable("commentId") Long commentId){
        return usersService.findCommentByUserAndPostId(userId, postId, commentId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}/posts")
    public void addPostToUser(@RequestBody Post p, @PathVariable("id") Long id){
        usersService.addPostToUser(id, p);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Long id){
        usersService.deleteById(id);
    }

    @GetMapping("/exceptionTest")
    public void testExceptionLogger(){
        int[] array = {1, 2, 3};
        System.out.println(array[3]);
    }
}
