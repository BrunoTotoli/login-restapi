package bruno.api.rest.springrestapi.config;

import bruno.api.rest.springrestapi.entities.Phone;
import bruno.api.rest.springrestapi.entities.User;
import bruno.api.rest.springrestapi.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@AllArgsConstructor
public class ConfigApp implements CommandLineRunner {

    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "jairo", "123123", "jairo delas", null);
        User user2 = new User(null, "jaime", "123123434", "jaime mar", null);
        User user3 = new User(null, "cleinto", "1231232123", "cleiton ro", null);
        User user4 = new User(null, "roverbal", "32423", "roverbal delas", null);
        User user5 = new User(null, "jose", "13223123", "jose delas", null);

        Phone phone = new Phone(null, "222-444", user1);
        userRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5));
        user1.setPhones(Arrays.asList(phone));
        userRepository.save(user1);


    }
}
