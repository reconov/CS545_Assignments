package com.spring.assignmentOne.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {
    private String username;
    private String password;
}
