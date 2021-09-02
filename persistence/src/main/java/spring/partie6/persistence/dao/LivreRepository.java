package spring.partie6.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import spring.partie6.persistence.entities.Livre;

public interface LivreRepository extends CrudRepository<Livre, Long> {

}