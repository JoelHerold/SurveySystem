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
    private boolean answer1;

    @Column()
    private boolean answer2;

    @Column()
    private boolean answer3;

    @Column()
    private boolean answer4;

    @Column()
    private String custom;

    @Column()
    private String hostMessage;

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
                ", question='" + question + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", option4='" + option4 + '\'' +
                ", answer1=" + answer1 +
                ", answer2=" + answer2 +
                ", answer3=" + answer3 +
                ", answer4=" + answer4 +
                ", custom='" + custom + '\'' +
                ", hostMessage='" + hostMessage + '\'' +
                ", host=" + host +
                //", participants=" + participants +
                '}';
    }
}




// TODO teilnehmer rausgenommen alle methoden und to string