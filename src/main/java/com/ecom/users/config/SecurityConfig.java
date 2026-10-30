package com.ecom.users.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) {
        http
                .csrf(csrf->csrf.disable())
//                .authorizeHttpRequests(request->request
//                        .anyRequest().authenticated())
                .authorizeHttpRequests(request->
                        request
                                .requestMatchers(HttpMethod.POST,"/v1/auth/register")
                                .permitAll()
                                .anyRequest()
                                .authenticated())
                .httpBasic(withDefaults());
        return http.build();
    }

}
