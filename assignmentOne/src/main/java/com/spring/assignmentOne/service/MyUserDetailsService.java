package com.spring.assignmentOne.service;

import com.spring.assignmentOne.domain.Users;
import com.spring.assignmentOne.repo.UsersRepo;
import com.spring.assignmentOne.service.Impl.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepo usersRepo;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Users user = usersRepo.findUsersByUsername(username);
        System.out.println("user = " + user);

        return new MyUserDetails(user);
    }

}
