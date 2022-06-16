package bruno.api.rest.springrestapi.services;

import bruno.api.rest.springrestapi.entities.User;
import bruno.api.rest.springrestapi.mapper.UserMapper;
import bruno.api.rest.springrestapi.repositories.UserRepository;
import bruno.api.rest.springrestapi.requests.UserPutRequestBody;
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
        return user.orElseThrow(() -> new IllegalArgumentException("This id dont exists"));
    }

    public User save(User user) {
        user.getPhones().stream()
                .filter(phone -> phone.getUser() == null)
                .forEach(phone -> phone.setUser(user));
        return userRepository.save(user);
    }

    public User update(Long id, User user) {
        User oldUser = findById(id);
        User userUpdated = user;
        userUpdated.setId(oldUser.getId());
        userUpdated.setPhones(oldUser.getPhones());
        return userRepository.save(userUpdated);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }


}
