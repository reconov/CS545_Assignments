package com.spring.assignmentOne.repo;

import com.spring.assignmentOne.domain.Post;

import java.util.List;

public interface PostRepo {

    public List<Post> getAll();

    public Post getById(int id);
}
