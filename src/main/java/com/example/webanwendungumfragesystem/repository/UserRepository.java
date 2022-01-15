package com.example.webanwendungumfragesystem.repository;

import com.example.webanwendungumfragesystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    //List<User> findExistingEmail(String email);

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);

}






