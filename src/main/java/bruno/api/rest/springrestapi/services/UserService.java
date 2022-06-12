package bruno.api.rest.springrestapi.services;

import bruno.api.rest.springrestapi.entities.User;
import bruno.api.rest.springrestapi.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User user) {
        User oldUser = findById(id);
        User newUser = User.builder()
                .id(oldUser.getId())
                .name(user.getName())
                .login(user.getLogin())
                .password(user.getPassword())
                .build();
        return userRepository.save(newUser);
    }


}
