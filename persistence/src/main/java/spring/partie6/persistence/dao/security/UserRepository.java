package spring.partie6.persistence.dao.security;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.partie6.persistence.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
