package spring.partie6.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import spring.partie6.service.ConfigurationService;

@Configuration
@Import({ConfigurationService.class})
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class ConfigurationMvc {
}
