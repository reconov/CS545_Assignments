package com.spring.assignmentOne.service;

import com.spring.assignmentOne.domain.dto.request.LoginRequest;
import com.spring.assignmentOne.domain.dto.response.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest loginRequest);

}
