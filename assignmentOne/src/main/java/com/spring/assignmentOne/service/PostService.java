package com.spring.assignmentOne.service;

import com.spring.assignmentOne.domain.Post;
import com.spring.assignmentOne.domain.dto.PostDto;

import java.util.List;

public interface PostService {

    List<Post> findAll();

    List<PostDto> getAllDto();

    Post findById(Long id);

    PostDto findByIdDto(Long id);

//    boolean save(Post p);

    void deleteById(Long id);

//    void updateById(int id, Post updatedPost);

    List<PostDto> filterByAuthor(String author);
}
