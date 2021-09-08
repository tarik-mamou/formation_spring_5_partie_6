package spring.partie6.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import spring.partie6.persistence.ConfigurationPersistence;

@Configuration
@Import(ConfigurationPersistence.class)
@Profile("prod")
/*@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)*/
public class ConfigurationService {


}
