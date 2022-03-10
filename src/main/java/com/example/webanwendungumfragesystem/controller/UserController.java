package com.example.webanwendungumfragesystem.controller;


import com.example.webanwendungumfragesystem.model.Survey;
import com.example.webanwendungumfragesystem.model.User;
import com.example.webanwendungumfragesystem.repository.SurveyRepository;
import com.example.webanwendungumfragesystem.repository.UserRepository;
import com.example.webanwendungumfragesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    SurveyRepository surveyRepository;
    @Autowired
    private UserRepository userRepository;

    //Start Page
    @GetMapping({"/home","/",""})
    public String viewHomePage(){
        return "index";
    }

    //Register page
    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("user", new User());
        return "register_page";
    }

    //create User, encrypt password, check if a User already exsits
    @PostMapping("/registering")
    public String registerUser(User user){
    //    if(userRepository.findExistingEmail(user.getEmail()).isEmpty()){
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodePassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodePassword);
            userRepository.save(user);

            return "registered";
     //   }else{
      //      return "register_page";
    //   }

    }
    //Mapping for the Dashboard
    @GetMapping("/user_dashboard")
    public String userDashboard (Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName(); //only for testing porpoise
        model.addAttribute("test",currentPrincipalName); //only for testing porpoise
        model.addAttribute("survey",new Survey());
        userService.setCurrentUser(); //only for testing porpoise
        return"user_dashboard";
    }


    //only for testing porpoise
    @GetMapping("/test")
    String test(Model model){
        model.addAttribute("something","testtttt");
        return "test";
    }

}
