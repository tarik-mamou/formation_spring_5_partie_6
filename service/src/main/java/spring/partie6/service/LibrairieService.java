package spring.partie6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.partie6.persistence.dao.ActionRepository;
import spring.partie6.persistence.dao.ApplicationUserRepository;
import spring.partie6.persistence.dao.LivreRepository;
import spring.partie6.persistence.dao.StockRepository;
import spring.partie6.persistence.entities.*;

import java.util.Date;

;

@Service
public class LibrairieService {
    //Logger logger = LoggerFactory.getLogger(LibrairieService.class);

    @Autowired
    LivreRepository livreRepository;

    @Autowired
    StockRepository stockRepository;

    @Autowired
    ApplicationUserRepository userRepository;

    @Autowired
    ActionRepository actionRepository;

    public Livre chercherLivre(String nomLivre) {
        return livreRepository.findByNom(nomLivre);
    }

    public Iterable<Livre> findAllLivre() {
        return livreRepository.findAll();
    }

    private Profil makeProfile() {
        return new Profil( new Date(), "roman");
    }

    private Auteur makeAuteur( String nom, String prenom) {
        return new Auteur(nom, prenom);
    }

    private Stock makeStock( int nombreStock) {
        return new Stock(nombreStock);
    }

    public void acheterLivre(String nomLivre, String nomUser) throws Exception {


        Livre livre = livreRepository.findByNom(nomLivre);

        if (livre == null) {

            throw new Exception("livre nom touv�");
        }

        ApplicationUser user = userRepository.findByUsername(nomUser);
        if (user == null) {

            throw new Exception("user nom touv�");

        }

        user.getLivres().add(livre);
        userRepository.save(user);
    }


    public Livre createLivre( String nomLivre, String nomAuteur, String prenomAuteur, int nombreStock) {
        Profil profil = makeProfile();
        Auteur auteur = makeAuteur(nomAuteur, prenomAuteur);
        Stock stock = makeStock( nombreStock);
        Livre livre = new Livre(profil, stock, auteur, nomLivre, 0);
        Livre savedLivre = livreRepository.save(livre);
        return savedLivre;
    }


    public void creerEtAcheterLivre(String nomUser, String nomLivre, String nomAuteur, String prenomAuteur, int nombreStock) throws Exception {
        createLivre(nomLivre, nomAuteur, prenomAuteur, nombreStock);

        acheterLivre(nomLivre, nomUser);
    }

    public ApplicationUser acheterLivreSansV�rification(String nomLivre, String nomUser) throws Exception {

        Livre livre = livreRepository.findByNom(nomLivre);


        ApplicationUser user = userRepository.findByUsername(nomUser);
        if (user == null) {

            throw new Exception("user nom touv�");

        }

        user.getLivres().add(livre);
        return userRepository.save(user);

    }

    // livre cr�e achat non effctu�
    // le livre est cr�� malgr� q une exeption aie �t� lnc�e
    public void creerEtAcheterLivreAvecException(int idProfile, int idAuteur, int idStock, String nomLivre, String nomUser, String nomAuteur, String
            prenomAuteur, int nombreStock) throws Exception {
        createLivre( nomLivre, nomAuteur, prenomAuteur, 30);
        acheterLivreSansV�rificationAvecException(nomLivre, nomUser);
    }

    public ApplicationUser acheterLivreSansV�rificationAvecException(String nomLivre, String nomUser) throws Exception {

        int number = 5 / 0;
        return acheterLivreSansV�rification(nomLivre, nomUser);
    }


    // livre non cr�e achat non effectu�
    // le livre  n est pas cr��  car une exeption a �t� lanc�e
    @Transactional
    public void creerEtAcheterLivreAvecExceptionTansactionGlobaleEtRuntimEx(int idLivre, int idProfile, int idAuteur, int idStock, String nomLivre, String nomUser, String nomAuteur, String
            prenomAuteur, int nombreStock) throws Exception {
        createLivre(nomLivre, nomAuteur, prenomAuteur, 30);
        acheterLivreSansV�rificationAvecException(nomLivre, nomUser);
    }

    // le livre est cr�� car l exception est checked
    @Transactional
    public void creerEtLivreEtCheckedEx(int idLivre, int idProfile, int idAuteur, int idStock, String nomLivre, String nomUser, String nomAuteur, String
            prenomAuteur, int nombreStock) throws Exception {
        createLivre( nomLivre, nomAuteur, prenomAuteur, 30);
        throw new Exception("test rollback Exception");
    }

    // le livre  n'est pas cr�� car l exception est non checked
    @Transactional
    public void creerEtLivreEtNonCheckedEx(int idLivre, int idProfile, int idAuteur, int idStock, String nomLivre, String nomUser, String nomAuteur, String
            prenomAuteur, int nombreStock) {
        createLivre(nomLivre, nomAuteur, prenomAuteur, 30);
        throw new RuntimeException("test rollback Exception");
    }
}
