package spring.partie6.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import spring.partie6.persistence.entities.UserLivre;
import spring.partie6.persistence.entities.UserLivreId;

public interface UserLivreRepository  extends CrudRepository<UserLivre, UserLivreId> {
}
