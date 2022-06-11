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

}
