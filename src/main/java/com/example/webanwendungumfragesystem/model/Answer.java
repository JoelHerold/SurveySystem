package com.example.webanwendungumfragesystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "Answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String question;

    @Column
    private boolean answer1;

    @Column
    private boolean answer2;

    @Column
    private boolean answer3;

    @Column
    private boolean answer4;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isAnswer1() {
        return answer1;
    }

    public void setAnswer1(boolean answer1) {
        this.answer1 = answer1;
    }

    public boolean isAnswer2() {
        return answer2;
    }

    public void setAnswer2(boolean answer2) {
        this.answer2 = answer2;
    }

    public boolean isAnswer3() {
        return answer3;
    }

    public void setAnswer3(boolean answer3) {
        this.answer3 = answer3;
    }

    public boolean isAnswer4() {
        return answer4;
    }

    public void setAnswer4(boolean answer4) {
        this.answer4 = answer4;
    }
}
