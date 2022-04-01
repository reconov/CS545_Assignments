package com.spring.assignmentOne.service.Impl;

import com.spring.assignmentOne.domain.Comment;
import com.spring.assignmentOne.repo.CommentRepo;
import com.spring.assignmentOne.repo.PostRepo;
import com.spring.assignmentOne.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    PostRepo postRepo;

    @Override
    public void addCommentByPostId(Long id, Comment newComment) {
        System.out.println("The current max id is : " + commentRepo.getMaxId());
        if(postRepo.findById(id) != null){ // should reduce calling twice
            newComment.setPost(postRepo.findById(id).orElse(null));
            commentRepo.save(newComment);
        }
    }

//    @Override
//    public void carefulSave(Comment c){
//        commentRepo.carefulSave(c);
//    }

}
