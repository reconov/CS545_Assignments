package com.spring.assignmentOne.service;

import com.spring.assignmentOne.domain.dto.request.AuthenticationRequest;
import com.spring.assignmentOne.domain.dto.response.AuthenticationResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    AuthenticationResponse login(AuthenticationRequest loginRequest);

}
