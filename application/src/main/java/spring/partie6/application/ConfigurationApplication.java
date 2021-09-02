package spring.partie6.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import spring.partie6.persistence.dao.LivreRepository;
import spring.partie6.persistence.entities.Livre;


@Configuration()
//@Import({ConfiguationRepository.class})
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

    @Service
    public static class LibrairieService {
        Logger logger = LoggerFactory.getLogger(LibrairieService.class);

        @Autowired
        LivreRepository livreRepository;


       public Iterable<Livre> findAllLivre(){
            return livreRepository.findAll();
        }


       // public List<Livre> findLivre3() {
      //      return jdbcTemplate.query("select * from livre", new BeanRowMapper());
       // }


    }
}
