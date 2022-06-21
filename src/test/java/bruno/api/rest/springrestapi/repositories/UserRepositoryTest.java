package bruno.api.rest.springrestapi.repositories;

import bruno.api.rest.springrestapi.entities.Phone;
import bruno.api.rest.springrestapi.entities.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@DisplayName("Repository Tests")
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void save() {
        User user = createUser();
        User userSaved = userRepository.save(user);

        Assertions.assertThat(userSaved).isNotNull();
        Assertions.assertThat(userSaved.getId()).isNotNull();
        Assertions.assertThat(userSaved).isNotNull();
        Assertions.assertThat(userSaved.getName()).isEqualTo(user.getName());
        Assertions.assertThat(userSaved.getLogin()).isEqualTo(user.getLogin());

    }

    @Test
    void update() {
        User user = createUser();
        User userSaved = userRepository.save(user);
        userSaved.setName("Cleiton");
        User userUpdate = userRepository.save(userSaved);

        Assertions.assertThat(userUpdate).isNotNull();
        Assertions.assertThat(userUpdate.getId()).isNotNull();
        Assertions.assertThat(userUpdate.getId()).isEqualTo(userSaved.getId());
        Assertions.assertThat(userUpdate.getName()).isNotEqualTo("Jairo");


    }

    static User createUser() {
        return User.builder()
                .name("Jairo")
                .id(1L)
                .password("jairosenha")
                .login("jairodelas")
                .phones(null)
                .build();
    }
}