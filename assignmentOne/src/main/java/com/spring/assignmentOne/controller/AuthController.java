package com.spring.assignmentOne.controller;

import com.spring.assignmentOne.domain.dto.request.AuthenticationRequest;
import com.spring.assignmentOne.domain.dto.response.AuthenticationResponse;
import com.spring.assignmentOne.service.AuthService;
import com.spring.assignmentOne.service.MyUserDetailsService;
import com.spring.assignmentOne.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    AuthService authService;

    @PostMapping
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authRequest)
            throws Exception {
     return ResponseEntity.ok().body(authService.login(authRequest));
    }

}
