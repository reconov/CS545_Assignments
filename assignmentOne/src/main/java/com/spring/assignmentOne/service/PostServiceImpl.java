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
    public List<Post> findAll(){
        return postRepo.findAll();
    }

    @Override
    public List<PostDto> findAllDto(){
        return postRepo.findAll().stream()
                .map(eachPost -> modelMapper.map(eachPost, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Post> findAllById(Long id){
        return postRepo.findAllById(id).orElse(null);
    }

    @Override
    public PostDto findByIdDto(Long id) {
        return modelMapper.map( findAllById(id), PostDto.class ); // map(from, to);
    }

    @Override
    public void deleteById(Long id) {
        postRepo.deleteById(id);
    }

    @Override
    public void save(Post p){
       postRepo.save(p);
    }

    @Override
    public void updateById(Long id, Post p){ // needs improved mapping
        if(p != null){
            var post = postRepo.findById(id).orElse(null);
            if(post != null){
                post.setAuthor(p.getAuthor());
                post.setContent(p.getContent());
                post.setTitle(p.getTitle());
                System.out.println("The update post : " + post);
                postRepo.save(post);
//                postRepo.save(modelMapper.map(postRepo.findById(id).orElse(null), p));
//                postRepo.save(modelMapper.map(post, p));
            }
        }
    }

    @Override
    public List<PostDto> filterByAuthor(String author){
        return findAllDto().stream()
                .filter(x -> x.getAuthor().equals(author))
                .collect(Collectors.toList());
    }
}
