package spring.partie6.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import spring.partie6.persistence.entities.Livre;
import spring.partie6.service.ConfigurationService;
import spring.partie6.service.LibrairieService;


@Configuration()
@Import({ConfigurationService.class})
public class ConfigurationApplication {


    Logger logger = LoggerFactory.getLogger(ConfigurationApplication.class);
    @Autowired
    LibrairieService librairieService;

    @Bean
    public CommandLineRunner demo(LibrairieService librairieService) {
        return (args) -> {
            Iterable<Livre> livres = librairieService.findAllLivre();
            System.out.println(livres.toString());
        };
    }

}
