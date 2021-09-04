package spring.partie6.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import spring.partie6.persistence.entities.Livre;
import spring.partie6.persistence.entities.Stock;

public interface StockRepository extends CrudRepository<Stock, Long> {
}
