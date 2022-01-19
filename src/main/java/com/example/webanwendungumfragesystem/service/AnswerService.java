package com.example.webanwendungumfragesystem.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class AnswerService {
    public static String currentUser;

    public String getCurrentUser(){
        return currentUser;
    }

    public void setCurrentUser(){
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    currentUser = authentication.getName();

}
}
