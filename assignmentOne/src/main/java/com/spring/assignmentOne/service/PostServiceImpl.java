package com.spring.assignmentOne.service;

import com.spring.assignmentOne.domain.Post;
import com.spring.assignmentOne.domain.dto.PostDto;
import com.spring.assignmentOne.repo.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Post> getAll(){
        return postRepo.getAll();
    }

    @Override
    public List<PostDto> getAllDto(){
        return postRepo.getAll().stream()
                .map(eachPost -> modelMapper.map(eachPost, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Post getById(int id){
        return postRepo.getById(id);
    }

    @Override
    public PostDto getByIdDto(int id) {
        return modelMapper.map( postRepo.getById(id), PostDto.class ); // map(from, to);
    }

    @Override
    public boolean save(Post p){
       return postRepo.save(p);
    }

    @Override
    public void updateById(int id, Post p){
        postRepo.update(id, p);
    }

    @Override
    public void deleteById(int id){
        postRepo.delete(id);
    }

    @Override
    public List<PostDto> filterByAuthor(String author){
        return getAllDto().stream()
                .filter(x -> x.getAuthor().equals(author))
                .collect(Collectors.toList());
    }
}
