package bruno.api.rest.springrestapi.util;

import bruno.api.rest.springrestapi.entities.User;

public class UserCreator {

    public static User createUserToBeSaved() {
        return User.builder()
                .name("Jairo")
                .password("jairosenha")
                .login("jairodelas")
                .phones(null)
                .build();
    }

    public static User createUserValid() {
        return User.builder()
                .name("Jairo")
                .id(1L)
                .password("jairosenha")
                .login("jairodelas")
                .phones(null)
                .build();
    }

    public static User createUserValidUpdate() {
        return User.builder()
                .name("Jairo")
                .id(1L)
                .password("jairosenha")
                .login("jairodelas")
                .phones(null)
                .build();
    }
}
