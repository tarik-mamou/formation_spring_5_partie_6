package spring.partie6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.partie6.persistence.dao.ActionRepository;
import spring.partie6.persistence.dao.LivreRepository;
import spring.partie6.persistence.dao.StockRepository;
import spring.partie6.persistence.dao.UserRepository;
import spring.partie6.persistence.entities.*;
;import java.util.Date;

@Service
public class LibrairieService {
    //Logger logger = LoggerFactory.getLogger(LibrairieService.class);

    @Autowired
    LivreRepository livreRepository;

    @Autowired
    StockRepository stockRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ActionRepository actionRepository;


    public Iterable<Livre> findAllLivre() {
        return livreRepository.findAll();
    }

    private Profil makeProfile(int idProfile) {
        return new Profil(idProfile, new Date(), "roman");
    }

    private Auteur makeAuteur(int idAuteur, String nom, String prenom) {
        return new Auteur(idAuteur, nom, prenom, null);
    }

    private Stock makeStock(int idStock, int nombreStock) {
        return new Stock(idStock, nombreStock);
    }

    public void acheterLivre(String nomLivre, String nomUser) throws Exception {


        Livre livre = livreRepository.findByNom(nomLivre);

        if (livre == null) {

            throw new Exception("livre nom touvé");
        }

        User user = userRepository.findByUsername(nomUser);
        if (user == null) {

            throw new Exception("user nom touvé");

        }

        user.getLivres().add(livre);
        userRepository.save(user);
    }


    public Livre createLivre(int idLivre, int idProfile, int idAuteur, int idStock, String nomLivre, String nomAuteur, String prenomAuteur, int nombreStock) {
        Profil profil = makeProfile(idProfile);
        Auteur auteur = makeAuteur(idAuteur, nomAuteur, prenomAuteur);
        Stock stock = makeStock(idStock, nombreStock);
        Livre livre = new Livre(idLivre, auteur, profil, stock, nomLivre, 100);
        Livre savedLivre = livreRepository.save(livre);
        return savedLivre;
    }


    public void creerEtAcheterLivre(int idLivre, int idProfile, int idAuteur, int idStock, String nomLivre, String nomUser, String nomAuteur, String prenomAuteur, int nombreStock) throws Exception {
        createLivre(idLivre, idProfile, idAuteur, idStock, nomLivre, nomAuteur, prenomAuteur, 30);

        acheterLivreSansVérification(nomLivre, nomUser);
    }

    public User acheterLivreSansVérification(String nomLivre, String nomUser) throws Exception {

        Livre livre = livreRepository.findByNom(nomLivre);


        User user = userRepository.findByUsername(nomUser);
        if (user == null) {

            throw new Exception("user nom touvé");

        }

        user.getLivres().add(livre);
        return userRepository.save(user);

    }

    // livre crée achat non effctué
    // le livre est créé malgré q une exeption aie été lncée
    public void creerEtAcheterLivreAvecException(int idLivre, int idProfile, int idAuteur, int idStock, String nomLivre, String nomUser, String nomAuteur, String
            prenomAuteur, int nombreStock) throws Exception {
        createLivre(idLivre, idProfile, idAuteur, idStock, nomLivre, nomAuteur, prenomAuteur, 30);
        acheterLivreSansVérificationAvecException(nomLivre, nomUser);
    }

    public User acheterLivreSansVérificationAvecException(String nomLivre, String nomUser) throws Exception {

        int number = 5 / 0;
        return acheterLivreSansVérification(nomLivre, nomUser);
    }


    // livre non crée achat non effectué
    // le livre  n est pas créé  car une exeption a été lancée
    @Transactional
    public void creerEtAcheterLivreAvecExceptionTansactionGlobaleEtRuntimEx(int idLivre, int idProfile, int idAuteur, int idStock, String nomLivre, String nomUser, String nomAuteur, String
            prenomAuteur, int nombreStock) throws Exception {
        createLivre(idLivre, idProfile, idAuteur, idStock, nomLivre, nomAuteur, prenomAuteur, 30);
        acheterLivreSansVérificationAvecException(nomLivre, nomUser);
    }

    // le livre est créé car l exception est checked
    @Transactional
    public void creerEtLivreEtCheckedEx(int idLivre, int idProfile, int idAuteur, int idStock, String nomLivre, String nomUser, String nomAuteur, String
            prenomAuteur, int nombreStock) throws Exception {
        createLivre(idLivre, idProfile, idAuteur, idStock, nomLivre, nomAuteur, prenomAuteur, 30);
        throw new Exception("test rollback Exception");
    }

    // le livre  n'est pas créé car l exception est non checked
    @Transactional
    public void creerEtLivreEtNonCheckedEx(int idLivre, int idProfile, int idAuteur, int idStock, String nomLivre, String nomUser, String nomAuteur, String
            prenomAuteur, int nombreStock)  {
        createLivre(idLivre, idProfile, idAuteur, idStock, nomLivre, nomAuteur, prenomAuteur, 30);
        throw new RuntimeException("test rollback Exception");
    }
}
