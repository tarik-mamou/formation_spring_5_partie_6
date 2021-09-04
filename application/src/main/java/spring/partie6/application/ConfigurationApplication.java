package spring.partie6.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import spring.partie6.service.ConfigurationService;
import spring.partie6.service.LibrairieService;


@Configuration()
@Import({ConfigurationService.class})
public class ConfigurationApplication {


    Logger logger = LoggerFactory.getLogger(ConfigurationApplication.class);
    @Autowired
    LibrairieService librairieService;

    @Bean
    public CommandLineRunner demarrer(LibrairieService librairieService) {
        return (args) -> {
            //Iterable<Livre> livres = librairieService.findAllLivre();
            //Livre livre = librairieService.createLivre("la peste", "albert", "camus",30);
            // librairieService.acheterLivre("une vie", "username_1");
            //  librairieService.creerEtAcheterLivre(2,2,2,2,"livre 2", "username_2","nom_auteur_2","prenom_auteur",50);
            // librairieService.creerEtAcheterLivreAvecException(3,3,3,3,"livre 3", "username_3","nom_auteur_3","prenom_auteur_3",50);
            //librairieService.creerEtAcheterLivreAvecException(4,4,4,4,"livre 4", "username_3","nom_auteur_4","prenom_auteur_4",50);
            //librairieService.creerEtAcheterLivreAvecException(5,5,5,5,"livre 5", "username_3","nom_auteur_5","prenom_auteur_5",50);
            //    librairieService.creerEtAcheterLivreAvecExceptionTansactionGlobaleEtRuntimEx(6,6,6,6,"livre 6", "username_3","nom_auteur_6","prenom_auteur_6",60);
            librairieService.creerEtLivreEtCheckedEx(7, 7, 7, 7, "livre 7", "username_3", "nom_auteur_7", "prenom_auteur_7", 60);

            librairieService.creerEtLivreEtNonCheckedEx(8, 8, 8, 8, "livre 8", "username_3", "nom_auteur_8", "prenom_auteur_8", 60);

            //  System.out.println(livre);
        };
    }

}
