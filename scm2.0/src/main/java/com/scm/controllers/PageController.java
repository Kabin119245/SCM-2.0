package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping(value = "/home")
    public String home() {
        System.out.println("Home Page handler");
        return "home";
    }

}
