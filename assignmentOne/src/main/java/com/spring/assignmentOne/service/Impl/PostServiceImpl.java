package com.spring.assignmentOne.service.Impl;

import com.spring.assignmentOne.domain.Post;
import com.spring.assignmentOne.domain.dto.PostDto;
import com.spring.assignmentOne.repo.PostRepo;
import com.spring.assignmentOne.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;

//    @Autowired
//    ModelMapper modelMapper;

    @Override
    public List<Post> findAll(){
        return postRepo.findAll();
    }

//    @Override
//    public List<PostDto> findAllDto(){  // convert to direct sql query
//        return postRepo.findAll().stream()
//                .map(eachPost -> modelMapper.map(eachPost, PostDto.class))
//                .collect(Collectors.toList());
//    }

    @Override
    public List<Post> findAllById(Long id){
        return postRepo.findAllById(id).orElse(null);
    }

//    @Override
//    public PostDto findByIdDto(Long id) {
//        return modelMapper.map( findAllById(id), PostDto.class ); // map(from, to);
//    }

    @Override
    public void deleteById(Long id) {
        postRepo.deleteById(id);
    }

    @Override
    public void save(Post p){
       postRepo.save(p);
    }

    @Override
    public void updateById(Long id, Post p){
        if(p != null){
            p.setId(id);
            postRepo.save(p);
        }
    }

//    @Override
//    public List<PostDto> filterByAuthor(String author){
//        return findAllDto().stream()
//                .filter(x -> x.getAuthor().equals(author))
//                .collect(Collectors.toList());
//    }

    @Override
    public List<Post> findPostByTitle(String title) {
        return postRepo.findPostByTitle(title);
    }


}
