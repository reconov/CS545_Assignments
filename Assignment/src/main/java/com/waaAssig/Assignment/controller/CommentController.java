package com.waaAssig.Assignment.controller;

import com.waaAssig.Assignment.domain.Comment;
import com.waaAssig.Assignment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}")
    public void addCommentByPostId( @RequestBody Comment c,
                                    @PathVariable("id") long id ) {
        commentService.addCommentByPostId(id, c);
    }

}
