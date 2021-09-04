package spring.partie6.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import spring.partie6.persistence.entities.Livre;
import spring.partie6.persistence.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
