/*

package com.example.webanwendungumfragesystem.controller;

import com.example.webanwendungumfragesystem.model.Answer;
import com.example.webanwendungumfragesystem.model.Survey;
import com.example.webanwendungumfragesystem.model.User;
import com.example.webanwendungumfragesystem.repository.AnswerRepository;
import com.example.webanwendungumfragesystem.repository.SurveyRepository;
import com.example.webanwendungumfragesystem.repository.UserRepository;
import com.example.webanwendungumfragesystem.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AnswerController {
    @Autowired
    AnswerService answerService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SurveyRepository surveyRepository;

    @Autowired
    AnswerRepository answerRepository;

    @GetMapping("/answer")
    public String answerSurvey(Model model) {
        model.addAttribute("answer",new Answer());
        String currentUser =  answerService.getCurrentUser();
        User user = userRepository.findByEmail(currentUser);
        //String test = user.getActiveSurveys().get(0).getOption1();

        model.addAttribute("user",user);
        model.addAttribute("userName",currentUser);
        return "/answer";
    }
    @PostMapping("/creating_answer")
    public String createSurvey(Answer answer){

        answerRepository.save(answer);
        return "user_dashboard";
}
}
*/