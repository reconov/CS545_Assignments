package com.spring.assignmentOne.controller;

import com.spring.assignmentOne.domain.Post;
import com.spring.assignmentOne.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestControllerAdvice
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable int id){
        System.out.println("Get post by id was excuted");
        return postService.getById(id);
    }

    @GetMapping("/")
    public List<Post> allPosts(){
        System.out.println("All posts was excuted");
        return postService.getAll();
    }

    @PostMapping()
}
