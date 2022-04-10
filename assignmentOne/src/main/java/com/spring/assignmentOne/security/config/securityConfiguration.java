package com.spring.assignmentOne.security.config;

import com.spring.assignmentOne.service.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

//@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class securityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

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
        auth.userDetailsService(myUserDetailsService);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/admin").hasAuthority("ADMIN")
                .antMatchers("/users").hasAnyAuthority("ADMIN", "CLIENT")
                .antMatchers("/").permitAll()
                .and().formLogin();
    }

//    @Bean(name="myPasswordEncoder")
//    public PasswordEncoder getPasswordEncoder() {
//        DelegatingPasswordEncoder delPasswordEncoder=  (DelegatingPasswordEncoder)PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        BCryptPasswordEncoder bcryptPasswordEncoder =new BCryptPasswordEncoder();
//        delPasswordEncoder.setDefaultPasswordEncoderForMatches(bcryptPasswordEncoder);
//        return delPasswordEncoder;
//    }


    @Bean
    @Primary
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

//    @Bean
//    public PasswordEncoder getPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }

}