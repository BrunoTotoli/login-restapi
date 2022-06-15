package bruno.api.rest.springrestapi.controllers;

import bruno.api.rest.springrestapi.entities.User;
import bruno.api.rest.springrestapi.mapper.UserMapper;
import bruno.api.rest.springrestapi.requests.UserPostRequestBody;
import bruno.api.rest.springrestapi.requests.UserPutRequestBody;
import bruno.api.rest.springrestapi.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @PostMapping(value = "/")
    public ResponseEntity<User> insert(@RequestBody UserPostRequestBody userPostRequestBody) {
        User user = UserMapper.INSTANCE.userPostToUser(userPostRequestBody);
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody UserPutRequestBody userPutRequestBody) {
        User user = User.builder()
                .id(userPutRequestBody.getId())
                .login(userPutRequestBody.getLogin())
                .password(userPutRequestBody.getPassword())
                .name(userPutRequestBody.getName())
                .build();
        return new ResponseEntity<>(userService.update(id, user), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
