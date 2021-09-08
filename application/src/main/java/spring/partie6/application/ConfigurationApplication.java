package spring.partie6.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import spring.partie6.persistence.dao.CustomQueriesObjects.LivreProfil;
import spring.partie6.persistence.entities.Livre;
import spring.partie6.service.ConfigurationService;
import spring.partie6.service.LibrairieService;

import java.util.List;
import java.util.Optional;


@Configuration()
@Import({ConfigurationService.class})
@Profile("prod")
public class ConfigurationApplication {


    Logger logger = LoggerFactory.getLogger(ConfigurationApplication.class);
    @Autowired
    LibrairieService librairieService;

    @Bean
    public CommandLineRunner demarrer(LibrairieService librairieService) {
        return (args) -> {
            List<Livre> livres = (List<Livre>) librairieService.findAllLivre();

            Page<Livre> livrePage = librairieService.findAllLivreWithPaging(0, 2);
            //Livre livre = librairieService.createLivre("la peste", "albert", "camus",30);
            //librairieService.acheterLivre("la peste", "user_name_1");
            //    librairieService.creerEtAcheterLivre("username_1", "livre 2", "nom_auteur_2","prenom_auteur",50);
                        System.out.println(livres);

            // Optional<Livre> livreOptional =  librairieService.findByPrix(222);

            //System.out.println(livrePage);
            //Optional<Livre> livreOptional2 = librairieService.findByPrixRequetePersonnalisee(30);
            //System.out.println(livreOptional2);
            //requete personnalisee avec join


            //Optional<LivreProfil> livreProfilOptional = librairieService.findByPrixRequetePersonnaliseeAvecJoin();
            //System.out.println(livreProfilOptional);


           // List<LivreProfil> livreProfilListOptional = librairieService.findByPrixRequetePersonnaliseeAvecJoinList();
            //System.out.println(livreProfilOptional);

     //********************************************* Gestion de transactions *************************************************

           //livre cree et associé a l utilsateur
           // librairieService.creerEtAcheterLivre("user_name_1","livre6","nomauteur4",
             //            "prenomAuteur4",35);


           // librairieService.creerEtAcheterLivreAvecException("user_name_1","livre8","nomauteur8",
             //       "prenomAuteur8",77);

            //librairieService.creerEtLivreEtCheckedEx("livre9","auteur9","nomauteur9",99);


          // librairieService.creerEtAcheterLivreAvecException(3,3,3,3,"livre 3", "username_3","nom_auteur_3","prenom_auteur_3",50);
            //librairieService.creerEtAcheterLivreAvecException(4,4,4,4,"livre 4", "username_3","nom_auteur_4","prenom_auteur_4",50);
            //librairieService.creerEtAcheterLivreAvecException(5,5,5,5,"livre 5", "username_3","nom_auteur_5","prenom_auteur_5",50);
            //    librairieService.creerEtAcheterLivreAvecExceptionTansactionGlobaleEtRuntimEx(6,6,6,6,"livre 6", "username_3","nom_auteur_6","prenom_auteur_6",60);
            //librairieService.creerEtLivreEtCheckedEx(7, 7, 7, 7, "livre 7", "username_3", "nom_auteur_7", "prenom_auteur_7", 60);

            //librairieService.creerEtLivreEtNonCheckedEx(8, 8, 8, 8, "livre 8", "username_3", "nom_auteur_8", "prenom_auteur_8", 60);
            //livres.forEach(livre -> System.out.println(livre.getNom()));

        //    librairieService.creerEtLivreEtCheckedEx("livre9","auteur9","nomauteur9",99);

            //librairieService.creerEtAcheterLivreDeuxServices("username_1", "livre 19", "nom_auteur_11","prenom_auteur_11",50);
            librairieService.creerEtLoguerAction("user_name_1", "livre 22", "nom_auteur_11","prenom_auteur_11",50);



        };
    }

}
