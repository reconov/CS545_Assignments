package com.waaAssig.Assignment.service.Impl;

import com.waaAssig.Assignment.domain.Comment;
import com.waaAssig.Assignment.repo.CommentRepo;
import com.waaAssig.Assignment.repo.PostRepo;
import com.waaAssig.Assignment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    PostRepo postRepo;

    @Override
    public void addCommentByPostId(long id, Comment newComment) {
        if(postRepo.findById(id) != null){ // should reduce calling twice
            newComment.setPost(postRepo.findById(id).orElse(null));
            commentRepo.save(newComment);
        }
    }

}
