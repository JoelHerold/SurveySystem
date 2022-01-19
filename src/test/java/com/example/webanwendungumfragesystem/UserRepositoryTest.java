package com.example.webanwendungumfragesystem;


import com.example.webanwendungumfragesystem.model.Answer;
import com.example.webanwendungumfragesystem.model.Survey;
import com.example.webanwendungumfragesystem.model.User;
import com.example.webanwendungumfragesystem.repository.AnswerRepository;
import com.example.webanwendungumfragesystem.repository.SurveyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AnswerRepository repo;
    @Autowired
    private SurveyRepository surveyRepository;

    //@Autowired
    //private UserRepository repo;
    @Test
    public void testCreateUser() {
        Answer answer = new Answer();
        answer.setAnswer1(true);

        Answer savedanswer = repo.save(answer);
        Answer existanswer = entityManager.find(Answer.class, savedanswer.getId());

        assertThat(answer.isAnswer1()).isEqualTo(existanswer.isAnswer1());
    }
/*
    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("delos-herold@web.de");
        user.setPassword("test");
        user.setFirstName("Delos");
        user.setLastName("Herold");

        User savedUser = repo.save(user);
        User existUser = entityManager.find(User.class,savedUser.getId());
        assertThat(user.getEmail()).isEqualTo((existUser.getEmail()));
    }



    @Test
    public void testCreateSurvey(){
        Survey survey = new Survey();
        //survey.setAnswer1(true);
        survey.setOption1("Test frage");
        survey.setCustom("hallllooo");
        survey.setHostMessage("asdasd");
       // survey.addParticipant("@asd");
       // survey.addParticipant("@sdddddd");


        Survey savedSurvey = surveyRepository.save(survey);
        Survey existSurvey = entityManager.find(Survey.class,savedSurvey.getId());
        assertThat(survey.getCustom()).isEqualTo((existSurvey.getCustom()));
       // assertThat(survey.getParticipants()).isEqualTo((existSurvey.getParticipants()));
    }

 */
}