package spring.partie6.persistence;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories()
@EntityScan()
public class ConfigurationPersistence {
}
