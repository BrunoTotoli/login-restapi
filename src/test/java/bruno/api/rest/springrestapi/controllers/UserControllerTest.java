package bruno.api.rest.springrestapi.controllers;

import bruno.api.rest.springrestapi.entities.User;
import bruno.api.rest.springrestapi.services.UserService;
import bruno.api.rest.springrestapi.util.UserCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class UserControllerTest {

    @InjectMocks
    UserController userController;

    @Mock
    UserService userService;


    @BeforeEach
    void setUp() {
        List<User> listUsers = List.of(UserCreator.createUserValid());
        BDDMockito.when(userService.findAll())
                .thenReturn(listUsers);
    }

    @Test
    void findAll() {
        String name = UserCreator.createUserValid().getName();
        List<User> list = userController.findAll().getBody();

        Assertions.assertThat(list).isNotEmpty().isNotNull().hasSize(1);
        Assertions.assertThat(list.get(0).getName()).isEqualTo(name);
    }
}