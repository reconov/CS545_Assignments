package com.spring.assignmentOne.service.Impl;

import com.spring.assignmentOne.domain.dto.request.AuthenticationRequest;
import com.spring.assignmentOne.domain.dto.response.AuthenticationResponse;
import com.spring.assignmentOne.service.AuthService;
import com.spring.assignmentOne.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;
    private JwtUtil jwtUtil;

    @Override
    public AuthenticationResponse login(AuthenticationRequest loginRequest){
        System.out.println("Authenticating in progress.... ");
        try {
            var result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                            loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            System.out.println("Bad Credentials");
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(loginRequest.getUsername());

        final String accessToken = jwtUtil.generateToken(userDetails);
//        final String refreshToken = jwtUtil.generateRefreshToken(loginRequest.getEmail());
        var loginResponse = new AuthenticationResponse(accessToken);//, refreshToken);
        return loginResponse;
    }

}
//   try {
//           authManager.authenticate(
//           new UsernamePasswordAuthenticationToken(
//           authRequest.getUsername(),
//           authRequest.getPassword()
//           ));
//           } catch (BadCredentialsException e) {
//           throw new Exception("Incorrect Credential details ", e);
//           }
//
//final UserDetails userDetails =
//        myUserDetailsService.loadUserByUsername(authRequest.getUsername());
//final String authToken = jwtTokenUtil.generateToken(userDetails);
//        return ResponseEntity.ok().body( new AuthenticationResponse(authToken));
