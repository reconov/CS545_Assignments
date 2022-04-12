package com.spring.assignmentOne.service;

import com.spring.assignmentOne.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepo usersRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        var user = usersRepo.findUsersByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("No user with the name : " + username + " matches our records");
        }
        List<? extends SimpleGrantedAuthority> roles =
                user.getRoles()
                        .stream()
                        .map(eachRole -> new SimpleGrantedAuthority(eachRole.getRole()))
                        .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                roles
        );
    }
}
