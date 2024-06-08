package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping(value = "/home")
    public String home(Model model) {
        System.out.println("Home Page handler");
        model.addAttribute("name", "Hello World");
        model.addAttribute("title", "Hello World");
        return "home";
    }

    //about
    @RequestMapping(value = "/about")
    public String aboutPage() {
        System.out.println("About page loading");
        return "about";
    }

    //services
    @RequestMapping(value = "/services")
    public String servicesPage() {
        System.out.println("Services Page loading");
        return "services";
    }

}
