package com.scm.controllers;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

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
    public String processRegister(@ModelAttribute UserForm userForm, HttpSession session) {
        //we have to fetch the form data
        System.out.println(userForm);

        //we have to validate the data
        //TODO:


        //we have to save the data to database\
        // converted UserForm --> User
//        User user = User.builder()
//                .name(userForm.getName())
//                .email(userForm.getEmail())
//                .password(userForm.getPassword())
//                .phoneNumber(userForm.getPhoneNumber())
//                .about(userForm.getAbout())
//                .profilePic("https://scontent.fktm17-1.fna.fbcdn.net/v/t39.30808-6/336674179_123851850670957_110306264273351523_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=5f2048&_nc_ohc=xPI5rnFGKHgQ7kNvgHgYhLh&_nc_ht=scontent.fktm17-1.fna&oh=00_AYDRlhEcNxq3TSuoFV57f19O_YHXv2i9WYbw6AldrzDwrA&oe=666E43C0")
//                .build();

//        build is removed beacuse it was not showing default values
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setAbout(userForm.getAbout());
        user.setProfilePic("https://scontent.fktm17-1.fna.fbcdn.net/v/t39.30808-6/336674179_123851850670957_110306264273351523_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=5f2048&_nc_ohc=xPI5rnFGKHgQ7kNvgHgYhLh&_nc_ht=scontent.fktm17-1.fna&oh=00_AYDRlhEcNxq3TSuoFV57f19O_YHXv2i9WYbw6AldrzDwrA&oe=666E43C0");



        User savedUser = userService.saveUser(user);
        System.out.println("User saved");


        // message = "Registration Successfully"

        //add the message

        Message message = Message.builder().content("Registration Successful").type(MessageType.red).build();
        session.setAttribute("message", message);



        //we have to redirect to the login page
        return "redirect:/register";

    }


}
