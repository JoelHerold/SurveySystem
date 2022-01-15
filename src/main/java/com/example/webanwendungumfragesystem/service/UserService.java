package com.example.webanwendungumfragesystem.service;

import com.example.webanwendungumfragesystem.model.User;
import com.example.webanwendungumfragesystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;


}
