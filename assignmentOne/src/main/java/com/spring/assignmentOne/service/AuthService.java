package com.spring.assignmentOne.service;

import com.spring.assignmentOne.domain.dto.request.LoginRequest;
import com.spring.assignmentOne.domain.dto.response.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    LoginResponse login(LoginRequest loginRequest);

}
