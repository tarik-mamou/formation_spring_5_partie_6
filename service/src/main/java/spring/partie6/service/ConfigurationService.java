package spring.partie6.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import spring.partie6.persistence.ConfigurationPersistence;

@Configuration
@Import(ConfigurationPersistence.class)
public class ConfigurationService {


}
