package com.example.webanwendungumfragesystem.controller;

import com.example.webanwendungumfragesystem.model.Answer;
import com.example.webanwendungumfragesystem.model.Survey;
import com.example.webanwendungumfragesystem.model.User;
import com.example.webanwendungumfragesystem.repository.SurveyRepository;
import com.example.webanwendungumfragesystem.repository.UserRepository;
import com.example.webanwendungumfragesystem.service.AnswerService;
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
    AnswerService answerService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SurveyRepository surveyRepository;

    @PostMapping ("/creating_survey")
    public String createSurvey(Survey survey){
        surveyRepository.save(survey);
        answerService.getCurrentUser();
        // alle User einfügen immer wenn eine Umfrag gestellt wird bekommen alle user diese damit ich später in survey Controller darauf zugreifen kann
        List<User> allUsers = userRepository.findAll();
       //for()
        return "user_dashboard";
    }

    @GetMapping("/create_survey")
    public String registerPage(Model model){
        model.addAttribute("survey", new Survey());
        return "create_survey";
    }

    @GetMapping(value = "/allSurveys", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Survey> showAllSurveys(Model model){
        User currentUser = userRepository.findByEmail( answerService.getCurrentUser());
        List<Survey> allSurveys =surveyRepository.findAll();
        model.addAttribute("surveys",allSurveys);
        model.addAttribute("user", currentUser);


        return allSurveys;
    }




/*
  @GetMapping("/addSurvey")
  public String addSurvey(Model model){
        String id ="";
        model.addAttribute("surveyId",id);
        return "addSurvey";
  }


    @PostMapping("/addingSurvey")
    public String addingSurvey(String sourceText){
        long surveyId = Long.parseLong(sourceText);
        User currentUser = userRepository.findByEmail(answerService.getCurrentUser());
        currentUser.addSurvey(surveyRepository.getById(surveyId));
        return "user_dashboard";
    }

    */
    /*
    @RequestMapping("/addingSurvey")
    public String process(Model model, @RequestParam String surveyId) {
    return "user_dashboard";
}
*/


}
