package com.waaAssig.Assignment.repo;

import com.waaAssig.Assignment.domain.Comment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepo extends CrudRepository<Comment, Long> {

    List<Comment> findAll();

    Optional<Comment> findById(Long id);

    @Query(value = "SELECT * from comment c" +
            "RIGHT JOIN post p on p.id = c.post_id" +
            "RIGHT JOIN users u on u.id = p.user_id" +
            "WHERE u.id = :uId and p.id = :pId and c.id = :cId",
            nativeQuery = true)
    Comment findCommentByUserAndPostIdCommentId(Long uId, Long pId, Long cId);

    // query to fetch users that have more than n comments to a post

}
