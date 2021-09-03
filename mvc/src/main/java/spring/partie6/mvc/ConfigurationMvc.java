package spring.partie6.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import spring.partie6.service.ConfigurationService;

@Configuration
@Import({ConfigurationService.class})
public class ConfigurationMvc {
}
