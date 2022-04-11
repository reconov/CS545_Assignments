package com.spring.assignmentOne.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl{// implements AuthService {

//    @Autowired
//    private final AuthenticationManager authenticationManager;
//    private final UserDetailsService userDetailsService;
//    private final JwtUtil jwtUtil;
//
//
//    @Override
//    public AuthenticationResponse login(AuthenticationRequest loginRequest){
//        try {
//            var result = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
//                            loginRequest.getPassword())
//            );
//        } catch (BadCredentialsException e) {
//            System.out.println("Bad Credentials");
//        }
//
//        final UserDetails userDetails = userDetailsService
//                .loadUserByUsername(loginRequest.getEmail());
//
//        final String accessToken = jwtUtil.generateToken(userDetails);
////        final String refreshToken = jwtUtil.generateRefreshToken(loginRequest.getEmail());
//        var loginResponse = new AuthenticationResponse(accessToken);//, refreshToken);
//        return loginResponse;
//    }

}
