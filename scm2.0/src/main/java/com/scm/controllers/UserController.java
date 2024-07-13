package com.scm.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {


    private Logger logger = LoggerFactory.getLogger(UserController.class);

    //user dashboard page
    @RequestMapping(value = "/dashboard")
    public String userDashboard() {
        return "user/dashboard";
    }
    //user profile page
    @RequestMapping(value = "/profile")
    public String userProfile(Principal principal) {
      String name =   principal.getName();
        return "user/profile";
    }

    //user add contact page
}
