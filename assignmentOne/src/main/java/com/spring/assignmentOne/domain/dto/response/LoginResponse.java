package com.spring.assignmentOne.domain.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class LoginResponse {
    private String accessToken;
}
