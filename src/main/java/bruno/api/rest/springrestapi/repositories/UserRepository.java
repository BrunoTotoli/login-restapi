package bruno.api.rest.springrestapi.repositories;

import bruno.api.rest.springrestapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
