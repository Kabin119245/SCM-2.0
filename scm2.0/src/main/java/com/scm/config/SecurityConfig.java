package com.scm.config;

import com.scm.services.impl.SecurityCustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.io.IOException;

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

    @Autowired
    private SecurityCustomUserDetailService userDetailService;

    @Autowired
    private OAuthAuthenticationSuccessHandler handler;

    //configuration of authentication provider


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {

       DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

       //object of user detail service
       daoAuthenticationProvider.setUserDetailsService( userDetailService);

       //object of password encoder
       daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        //configuration

        //url configurations(public, private)
        httpSecurity.authorizeHttpRequests(authorize->{
//            authorize.requestMatchers("/home","/register","/about","/login","/services").permitAll();
            authorize.requestMatchers("/user/**").authenticated();
            authorize.anyRequest().permitAll();

        });

        //form default login
        //if we want to change in form login related, we come here
        httpSecurity.formLogin(formLogin -> {
            formLogin.loginPage("/login")
                    .loginProcessingUrl("/authenticate")
                    .successForwardUrl("/user/dashboard")
                    .failureForwardUrl("/login?error=true")
                    .usernameParameter("email")
                    .passwordParameter("password");
        });

        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        httpSecurity.logout(logoutForm -> {
            logoutForm.logoutUrl("/logout");
            logoutForm.logoutSuccessUrl("/login?logout=true");
        });

        //oauth configuration
        httpSecurity.oauth2Login(oauth -> {
            oauth.loginPage("/login");
            oauth.successHandler(handler);
        });

        return httpSecurity.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
