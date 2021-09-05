package spring.partie6.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import spring.partie6.persistence.entities.ApplicationUser;

public interface ApplicationUserRepository extends CrudRepository<ApplicationUser, Long> {

    ApplicationUser findByUsername(String username);
}
