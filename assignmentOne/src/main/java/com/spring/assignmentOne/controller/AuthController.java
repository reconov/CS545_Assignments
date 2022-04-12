package com.spring.assignmentOne.controller;

import com.spring.assignmentOne.domain.dto.request.AuthenticationRequest;
import com.spring.assignmentOne.domain.dto.response.AuthenticationResponse;
import com.spring.assignmentOne.service.JwtUserDetailsService;
import com.spring.assignmentOne.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
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

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        System.out.println("token = " + token);
        return ResponseEntity.ok(new AuthenticationResponse(token));

    }
    
    private void authenticate(String username, String password) throws Exception {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED");
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS");
        }
    }
    
}
