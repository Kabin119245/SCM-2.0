package com.scm.controllers;

import com.scm.forms.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    //contact
    @RequestMapping(value = "/contact")
    public String contactPage() {
        System.out.println("Contact Page loading");
        return "contact";
    }
    //login
    @RequestMapping(value = "/login")
    public String loginPage() {
        System.out.println("Login Page loading");
        return "login";
    }
    //register
    @RequestMapping(value = "/register")
    public String registerPage(Model model) {
        System.out.println("Register Page loading");
        UserForm userForm = new UserForm();
//        for checking
//        userForm.setName("Kabin");
//        userForm.setEmail("girika@gmi.com");
//        userForm.setPassword("123");
//        userForm.setAbout("Kabin ufjdfdjfdjvbdjbdjvb");
        model.addAttribute("userForm", userForm);
        return "register";
    }

    //processing register or sign up

    @RequestMapping(value = "/doRegister", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm) {
        //we have to fetch the form data
        System.out.println(userForm);

        //we have to validate the data
        //TODO:


        //we have to save the data to database



        // message = "Registration Successfully"




        //we have to redirect to the login page
        return "redirect:/login";

    }


}
