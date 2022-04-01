package com.spring.assignmentOne.repo;

import com.spring.assignmentOne.domain.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepo extends CrudRepository<Post, Long> {

    List<Post> findAll();

    Optional<Post> findById(Long id);

    void deleteById(Long id);

}

