package com.spring.assignmentOne.controller;

import com.spring.assignmentOne.domain.dto.request.AuthenticationRequest;
import com.spring.assignmentOne.service.JwtUserDetailsService;
import com.spring.assignmentOne.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private AuthenticationManager authManager;


    @Autowired
    private JwtUserDetailsService userDetailsService;

    @PostMapping
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authRequest)
            throws Exception {
        System.out.println("Request Accepted : " + authRequest);
        return ResponseEntity.ok().body(userDetailsService(authRequest));
    }

}
