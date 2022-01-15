package com.example.webanwendungumfragesystem;


import com.example.webanwendungumfragesystem.model.User;
import com.example.webanwendungumfragesystem.repository.UserRepository;
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
    private UserRepository repo;


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
}