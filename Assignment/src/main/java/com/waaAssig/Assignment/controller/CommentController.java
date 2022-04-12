package com.spring.assignmentOne.controller;

import com.spring.assignmentOne.domain.Comment;
import com.spring.assignmentOne.service.CommentService;
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
                                    @PathVariable("id") Long id ) {
        commentService.addCommentByPostId(id, c);
    }

}
