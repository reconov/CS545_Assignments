package com.waaAssig.Assignment.service;

import com.waaAssig.Assignment.domain.Comment;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {

    void addCommentByPostId(long id, Comment c);

}
