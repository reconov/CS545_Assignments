package com.spring.assignmentOne.dao;

import com.spring.assignmentOne.model.DAOUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {
	
	DAOUser findByUsername(String username);
	
}