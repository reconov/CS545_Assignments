package com.waaAssig.Assignment.repo;

import com.waaAssig.Assignment.domain.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepo extends CrudRepository<Post, Long> {

    List<Post> findAll();

    Optional<Post> findById(long id);

    Optional<List<Post>> findAllById(Long id);

    void deleteById(Long id);

    @Query("select p from Post p where p.title = :title")
    List<Post> findPostByTitle(String title);
    
}

