package com.example.webanwendungumfragesystem.controller;

import com.example.webanwendungumfragesystem.model.Survey;
import com.example.webanwendungumfragesystem.model.User;
import com.example.webanwendungumfragesystem.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SurveyController {

    @Autowired
    SurveyRepository surveyRepository;

    @PostMapping ("/creating_survey")
    public String createSurvey(Survey survey){

        surveyRepository.save(survey);
        return "user_dashboard";
    }

    @GetMapping("/create_survey")
    public String registerPage(Model model){
        model.addAttribute("survey", new Survey());
        return "create_survey";
    }

    @GetMapping("/allSurveys")
    public String showAllSurveys(Model model){
        List<Survey> allSurveys =surveyRepository.findAll();
        model.addAttribute("Surveys", allSurveys);
        return "allSurveys";
    }

}
