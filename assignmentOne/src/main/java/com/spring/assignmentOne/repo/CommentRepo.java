package com.spring.assignmentOne.repo;

import com.spring.assignmentOne.domain.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepo extends CrudRepository<Comment, Long> {

    List<Comment> findAll();

    Optional<Comment> findById(Long id);

    @Query( value = "SELECT max(id) FROM Comment")
    Long getMaxId();

//    @Query( value = "Insert INTO comment ( id, name, post_id ) " +
//            "VALUES ( :getMaxId(), :c.getName(), :c.getPost().getId() )",
//            nativeQuery = true)
//    void carefulSave(Comment c);

    // query to fetch users that have more than n comments to a post

}
