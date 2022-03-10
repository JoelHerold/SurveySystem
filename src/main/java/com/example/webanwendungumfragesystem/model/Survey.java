package com.example.webanwendungumfragesystem.model;


import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "Survey")
public class Survey {
    //model for Survey
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String surveyName;
    @Column
    private String question;
    @Column()
    private String answer;



/*
    @ElementCollection
    @CollectionTable(name = "my_list", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "participants")
    private List<String> participants =new ArrayList<>();

    public List<String> getParticipants() {
        return participants;
    }

    public void addParticipant(String email) {
        participants.add(email);
    }
*/

    @Override
    public String toString() {
        return "Survey{" +
                "id=" + id +
                ", surveyName='" + surveyName + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}




// TODO teilnehmer rausgenommen alle methoden und to string