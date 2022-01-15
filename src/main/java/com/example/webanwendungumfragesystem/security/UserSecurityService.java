package com.example.webanwendungumfragesystem.security;

import com.example.webanwendungumfragesystem.model.User;
import com.example.webanwendungumfragesystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class UserSecurityService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    private User user;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);

        if(user==null){
            throw new UsernameNotFoundException("User not found");
        }

        return new UserSecurity(user);

    }
}
