package com.spring.assignmentOne.controller;

import com.spring.assignmentOne.domain.Post;
import com.spring.assignmentOne.domain.dto.PostDto;
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
    @GetMapping
    public List<Post> allPostDefault(){ // default -> redirect to V1 ( empty header )
        return allPostsV1();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping( headers = "X-API-VERSION=1")
    public List<Post> allPostsV1(){
        return postService.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping( headers = "X-API-VERSION=2")
    public List<PostDto> allPostsV2(){
        return postService.getAllDto();
    }

    @GetMapping(value = "/{id}")
    public Post getPostById(@PathVariable int id){
        return postService.getById(id);
    }

    @GetMapping( value = "/{id}", headers = "X-API-VERSION=2")
    public PostDto getPostByIdDto(@PathVariable int id){
        return postService.getByIdDto(id);
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

    @GetMapping("/filter")
    public List<PostDto> filtered(@RequestParam String author){
        return postService.filterByAuthor(author);
    }
}
