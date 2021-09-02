package application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration()
//@Import({ConfiguationRepository.class})
public class ConfigurationApplication {


    Logger logger = LoggerFactory.getLogger(ConfigurationApplication.class);
    @Autowired
    jpa.application.LibrairieService librairieService;

    @Bean
    public CommandLineRunner demo(jpa.application.LibrairieService librairieService) {
        return (args) -> {
            Iterable<jpa.persistence.entities.Livre> livres = librairieService.findAllLivre();
            System.out.println(livres.toString());
        };
    }
}
