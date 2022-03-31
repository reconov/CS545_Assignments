package com.spring.assignmentOne.controller;

import com.spring.assignmentOne.domain.Post;
import com.spring.assignmentOne.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Post controller
 * @author En. Abraham Bisrat
 *
 */

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/")
    public List<Post> allPostDefault(){ // default( without header redirect to V1)
        return allPostsV1();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping( value = "/", headers = "X-API-VERSION=1")
    public List<Post> allPostsV1(){
        return postService.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping( value = "/", headers = "X-API-VERSION=2")
    public void allPostsV2(){
        System.out.println("Version 2 all posts has been requested");
    }

    @GetMapping(value = "/{id}")
    public Post getPostById(@PathVariable int id){
        return postService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "")
    public boolean newPost(@RequestBody Post newPost){
        return postService.save(newPost);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePost(@PathVariable int id, @RequestBody Post post){
        postService.updateById(id, post);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable int id){
        postService.deleteById(id);
    }

}
