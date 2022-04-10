package com.spring.assignmentOne.service;

import com.spring.assignmentOne.repo.UsersRepo;
import com.spring.assignmentOne.service.Impl.MyUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service("userDetailsService")
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    private final UsersRepo usersRepo;

    public MyUserDetailsService(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        var user = usersRepo.findUsersByUsername(username);
        var userDetails = new MyUserDetails(user);
        System.out.println("userDetails = " + userDetails);

        return userDetails;
    }

}