package com.spring.assignmentOne.repo;

import com.spring.assignmentOne.domain.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends CrudRepository<Comment, Long> {

    List<Comment> findAll();



    // query to fetch users that have more than n comments to a post

}
