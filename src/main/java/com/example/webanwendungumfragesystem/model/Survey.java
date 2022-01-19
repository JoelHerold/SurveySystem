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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String surveyName;
    @Column
    private String question;
    @Column()
    private String option1;
    @Column()
    private String option2;
    @Column()
    private String option3;
    @Column()
    private String option4;

    @Column()
    private String custom;

    @Column()
    private String hostMessage;

    @OneToMany
    @CollectionTable(name = "given_answers", joinColumns = @JoinColumn(name = "id"))
    private List<Answer> givenAnswers = new ArrayList<>();
/*
    @OneToOne
    @JoinColumn
    private User host;


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
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", option4='" + option4 + '\'' +
                ", custom='" + custom + '\'' +
                ", hostMessage='" + hostMessage + '\'' +
                '}';
    }
}




// TODO teilnehmer rausgenommen alle methoden und to string