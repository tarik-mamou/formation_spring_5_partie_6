package spring.partie6.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import spring.partie6.persistence.entities.Action;

public interface ActionRepository extends CrudRepository<Action,Long> {
}
