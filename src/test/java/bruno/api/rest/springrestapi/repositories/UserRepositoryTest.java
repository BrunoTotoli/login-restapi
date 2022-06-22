package bruno.api.rest.springrestapi.repositories;

import bruno.api.rest.springrestapi.entities.User;
import bruno.api.rest.springrestapi.util.UserCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static bruno.api.rest.springrestapi.util.UserCreator.createUserValid;


@DataJpaTest
@DisplayName("Repository Tests")
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("Save user when successful")
    void save_SaveUser() {
        User user = createUserValid();
        User userSaved = userRepository.save(user);

        Assertions.assertThat(userSaved).isNotNull();
        Assertions.assertThat(userSaved.getId()).isNotNull();
        Assertions.assertThat(userSaved).isNotNull();
        Assertions.assertThat(userSaved.getName()).isEqualTo(user.getName());
        Assertions.assertThat(userSaved.getLogin()).isEqualTo(user.getLogin());

    }

    @Test
    @DisplayName("Save and Update user when successful")
    void update_UpdateUser() {
        User user = createUserValid();
        User userSaved = userRepository.save(user);
        userSaved.setName("Cleiton");
        User userUpdate = userRepository.save(userSaved);

        Assertions.assertThat(userUpdate).isNotNull();
        Assertions.assertThat(userUpdate.getId()).isNotNull();
        Assertions.assertThat(userUpdate.getId()).isEqualTo(userSaved.getId());
        Assertions.assertThat(userUpdate.getName()).isNotEqualTo("Jairo");

    }

    @Test
    @DisplayName("Delete user when successful")
    void remove_RemovesUser() {
        User user = createUserValid();
        User save = userRepository.save(user);
        userRepository.delete(save);
        Optional<User> userFindById = userRepository.findById(save.getId());

        Assertions.assertThat(userFindById).isEmpty();


    }

    @Test
    @DisplayName("Find by Name and return list of users when successful")
    void findUserByName_ReturnListOfAnime() {
        User user = createUserValid();
        User savedUser = userRepository.save(user);
        String name = savedUser.getName();

        List<User> users = userRepository.findByName(name);

        Assertions.assertThat(users).isNotEmpty().contains(savedUser);
    }

    @Test
    @DisplayName("Find by name and return empty list when successful")
    void findUserByName_ReturnEmptyList() {
        User user = createUserValid();
        User savedUser = userRepository.save(user);
        String name = "Robin";

        List<User> users = userRepository.findByName(name);

        Assertions.assertThat(users).isEmpty();

    }
}