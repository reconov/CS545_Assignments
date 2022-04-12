package com.spring.assignmentOne.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class securityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    DataSource dataSource;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void configure(AuthenticationManagerBuilder auth)
            throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery(
//                        "select username, password, enabled "
//                        + "from users where username = ?")
//                .authoritiesByUsernameQuery(
//                        "select username, role from users_roles ur "
//                        + "right join users u on ur.users_id = u.id "
//                        + "right join role r on r.id =  ur.roles_id "
//                        + "where u.username = ?");
        auth.userDetailsService(userDetailsService);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/admin").hasAuthority("ADMIN")
                .antMatchers("/users").hasAnyAuthority("ADMIN", "CLIENT")
                .antMatchers("/auth").permitAll()
                .anyRequest().authenticated();
    }

    @Bean
    @Primary
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

//    @Bean (name = BeanIds.AUTHENTICATION_MANAGER)
//    @Override public
//    AuthenticationManager Authenticationmanagerbean () throws Exception {
//        return super.authenticationConfiguration();
//    }

}
