package com.example.webanwendungumfragesystem.repository;

import com.example.webanwendungumfragesystem.model.Survey;
import com.example.webanwendungumfragesystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SurveyRepository extends JpaRepository<Survey,Long> {


}
