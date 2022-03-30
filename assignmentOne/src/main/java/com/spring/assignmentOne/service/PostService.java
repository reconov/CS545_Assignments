package com.spring.assignmentOne.service;

import com.spring.assignmentOne.domain.Post;

import java.util.List;

public interface PostService {

    List<Post> getAll();

    Post getById(int id);

    boolean save(Post p);

    void deleteById(int id);

    void updateById(int id);
}
