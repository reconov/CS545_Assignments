package com.waaAssig.Assignment.controller;

import com.waaAssig.Assignment.domain.Post;
import com.waaAssig.Assignment.service.PostService;
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
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping()
    public String index(){
        return ("<h1>@elcome to posts endpoint</h1>");
    }

//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping
//    public List<Post> allPostDefault(){ // default -> redirect to V1 ( empty header )
//        return allPostsV1();
//    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping( headers = "X-API-VERSION=1")
    public List<Post> allPostsV1(){
        return postService.findAll();
    }

//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping( headers = "X-API-VERSION=2")       // versioning has changed to uri
//    public List<PostDto> allPostsV2(){
//        return postService.findAllDto();
//    }

    @GetMapping(value = "/{id}")
    public List<Post> getPostById(@PathVariable("id") Long id){
        return postService.findAllById(id);
    }

//    @GetMapping( value = "/{id}", headers = "X-API-VERSION=2")
//    public PostDto getPostByIdDto(@PathVariable("id") Long id){
//        return postService.findByIdDto(id);
//    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "")
    public void newPost(@RequestBody Post newPost){
        postService.save(newPost);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePost(@PathVariable Long id, @RequestBody Post post){
        postService.updateById(id, post);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id){
        postService.deleteById(id);
    }

//    @GetMapping("/filter")
//    public List<PostDto> filtered(@RequestParam String author){
//        return postService.filterByAuthor(author);
//    }

}
