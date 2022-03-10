package com.example.webanwendungumfragesystem.controller;


import com.example.webanwendungumfragesystem.model.Survey;
import com.example.webanwendungumfragesystem.model.User;
import com.example.webanwendungumfragesystem.repository.SurveyRepository;
import com.example.webanwendungumfragesystem.repository.UserRepository;

import com.example.webanwendungumfragesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SurveyController {


    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SurveyRepository surveyRepository;

//add a new survey and save in Database
    @PostMapping("/add_survey")
    public String addSurvey(Survey survey) {
        surveyRepository.save(survey);
        return "user_dashboard";
    }
//create a new Survey
    @GetMapping("/create_survey")
    public String registerPage(Model model) {
        model.addAttribute("survey", new Survey());
        return "create_survey";
    }

    //return all Questions as a List of Objects in Json
    @GetMapping(value = "/all_survey", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Survey> showAllSurveys(Model model) {
        User currentUser = userRepository.findByEmail(userService.getCurrentUser());
        List<Survey> allSurveys = surveyRepository.findAll();
        //model.addAttribute("surveys",allSurveys);
        //model.addAttribute("user", currentUser);


        return allSurveys;
    }
}