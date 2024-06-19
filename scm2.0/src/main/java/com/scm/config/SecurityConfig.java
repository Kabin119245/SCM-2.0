package com.scm.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    //user create and login using java code with in memory service

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user1 = User
//                .withDefaultPasswordEncoder()
//                .username("admin123")
//                .password("admin123")
//                .roles("ADMIN","USER")
//                .build();
//
//        UserDetails user2 = User
//                .withDefaultPasswordEncoder()
//                .username("user123")
//                .password("user123")
//              //  .roles("ADMIN","USER")
//                .build();
//
//        var inMemoryUserDetailsManager = new InMemoryUserDetailsManager(user1,user2);
//        return inMemoryUserDetailsManager;
//
//    }
    



}
