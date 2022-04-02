package com.spring.assignmentOne.repo;

import com.spring.assignmentOne.domain.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepo extends CrudRepository<Users, Long> {

    List<Users> findAll();

    Optional<Users> findById(Long id);

    @Query("select u from Users u where u.posts.size >= :n")
    List<Users> findMoreThanOnePost(int n);

    void deleteById(Long id);

//    @Query("select u from Users.posts u where u.title = :title")
//    List<Users> findUsersByPostTitle(String title);

//    default List<Users> findUsersByPostTitle(String title) { return null;}

}
