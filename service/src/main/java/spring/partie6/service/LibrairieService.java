package spring.partie6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.partie6.persistence.dao.LivreRepository;
import spring.partie6.persistence.entities.Auteur;
import spring.partie6.persistence.entities.Livre;
import spring.partie6.persistence.entities.Profil;
;import java.util.Date;

@Service
public class LibrairieService {
    //Logger logger = LoggerFactory.getLogger(LibrairieService.class);

    @Autowired
    LivreRepository livreRepository;


    public Iterable<Livre> findAllLivre() {
        return livreRepository.findAll();
    }

    private Profil makeProfile() {
        return new Profil(3, new Date(), "roman");
    }

    private Auteur makeAuteur(String nom, String prenom) {
        return new Auteur(3, nom, prenom, null);
    }

    public Livre saveLivre(String nomLivre, String nomAuteur, String prenomAuteur) {
        Profil profil = makeProfile();
        Auteur auteur = makeAuteur(nomAuteur, prenomAuteur);
        Livre livre = new Livre(3, auteur, profil, nomLivre);
        Livre savedLivre=livreRepository.save(livre);
        return savedLivre;
    }


}
