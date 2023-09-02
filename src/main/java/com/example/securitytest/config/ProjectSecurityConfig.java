package com.example.securitytest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)throws Exception{
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/v1/account/get-account").hasAuthority("admin")
                .antMatchers("/api/v1/loan/get-loan").hasAuthority("user")
                .antMatchers("/api/v1/notice/get-notice","/api/v1/user/register").permitAll()
                .and().formLogin().and().httpBasic();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
