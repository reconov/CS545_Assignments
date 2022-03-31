package com.spring.assignmentOne.service;

import com.spring.assignmentOne.domain.Post;
import com.spring.assignmentOne.domain.dto.PostDto;

import java.util.List;

public interface PostService {

    List<Post> getAll();

    List<PostDto> getAllDto();

    Post getById(int id);

    PostDto getByIdDto(int id);

    boolean save(Post p);

    void deleteById(int id);

    void updateById(int id, Post updatedPost);
}
