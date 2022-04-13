package com.waaAssig.Assignment.service;

import com.waaAssig.Assignment.domain.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    List<Post> findAll();

//    List<PostDto> findAllDto();

    List<Post> findAllById(Long id);

//    PostDto findByIdDto(Long id);

    void save(Post p);

    void deleteById(Long id);

    void updateById(Long id, Post updatedPost);

//    List<PostDto> filterByAuthor(String author);

    List<Post> findPostByTitle(String title);

}
