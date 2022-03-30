package com.spring.assignmentOne.service;

import com.spring.assignmentOne.domain.Post;
import com.spring.assignmentOne.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepo postRepo;

    @Override
    public List<Post> getAll(){
        return postRepo.getAll();
    }

    @Override
    public Post getById(int id){
        return postRepo.getById(id);
    }

    @Override
    public boolean save(Post p){
       return postRepo.save(p);
    }
}
