package com.example.webanwendungumfragesystem.model;




import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name="lastName",nullable = false)
    private String lastName;

    @OneToMany
    @CollectionTable(name = "active_surveys ", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "actSurv", nullable = false)
    private List<Survey> activeSurveys = new ArrayList<>();

    public void addSurvey(Survey survey){
        activeSurveys.add(survey);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", activeSurveys=" + activeSurveys +
                '}';
    }
}
