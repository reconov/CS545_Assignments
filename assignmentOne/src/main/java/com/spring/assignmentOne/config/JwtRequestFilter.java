package com.spring.assignmentOne.config;

import com.spring.assignmentOne.service.JwtUserDetailsService;
import com.spring.assignmentOne.utils.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Security;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res,
                                    FilterChain chain) throws ServletException, IOException {
        final String requestTokenHeader = req.getHeader("Authorization");

        String username = null;
        String jwtToken = null;

        // Strip the auth header value by splicing the first seven chars
        if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7);

            try{
                username = jwtTokenUtil.getUsernameFromToken(jwtToken);
            } catch(IllegalArgumentException e) {
                System.out.println("No matching user by the name given ");
            } catch(ExpiredJwtException e) {
                System.out.println("Token has outlived its usefulness ");
            }
        } else {
            logger.warn("JWT Token does not begin with Bearer String ");
        }

        // After token has been validated
        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);

            // if token is valid configure spring security to manually set authentication
            if(jwtTokenUtil.validateToken(jwtToken, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                        = new UsernamePasswordAuthenticationToken
                        (userDetails, null, userDetails.getAuthorities());

                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));

                // After setting the authentication in the context, we specify
                // that the current user is authenticated. So it passes the Spring security config successfully
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }

            chain.doFilter(req, res);
        }

    }


}
