package com.example.webanwendungumfragesystem.service;

import com.example.webanwendungumfragesystem.model.User;
import com.example.webanwendungumfragesystem.repository.SurveyRepository;
import com.example.webanwendungumfragesystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


//to get the current User. In my Case only for testing. Would be needed if the Application has more User handling. Was
//needed in an early Version
@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    SurveyRepository surveyRepository;

    public static String currentUser;

    public String getCurrentUser(){
        return currentUser;
    }

    public void setCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        currentUser = authentication.getName();

    }

}
