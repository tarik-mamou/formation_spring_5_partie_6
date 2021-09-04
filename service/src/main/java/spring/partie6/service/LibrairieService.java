package spring.partie6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.partie6.persistence.dao.LivreRepository;
import spring.partie6.persistence.dao.StockRepository;
import spring.partie6.persistence.dao.UserLivreRepository;
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
    UserLivreRepository userLivreRepository;

    @Autowired
    UserRepository userRepository;


    public Iterable<Livre> findAllLivre() {
        return livreRepository.findAll();
    }

    private Profil makeProfile() {
        return new Profil(3, new Date(), "roman");
    }

    private Auteur makeAuteur(String nom, String prenom) {
        return new Auteur(3, nom, prenom, null);
    }

    private Stock makeStock(int nombreStock) {
        return new Stock(3, nombreStock);
    }


    public Livre createLivre(String nomLivre, String nomAuteur, String prenomAuteur , int nombreStock) {
        Profil profil = makeProfile();
        Auteur auteur = makeAuteur(nomAuteur, prenomAuteur);
        Stock stock = makeStock(nombreStock);
        Livre livre = new Livre(3, auteur, profil, stock, nomLivre, 100);
        Livre savedLivre = livreRepository.save(livre);
        return savedLivre;
    }

    public void acheterLivre(String nomLivre,String nomUser) throws Exception {



        Livre livre = livreRepository.findByNom(nomLivre);

        if(livre==null){

            throw new Exception("livre nom touvé");
        }

        User user=userRepository.findByUsername(nomUser);
        if(user==null){

            throw new Exception("user nom touvé");

        }
        UserLivre userLivre=new UserLivre();
        userLivre.setUser(user);
        userLivre.setLivre(livre);
        user.getUserLivres().add(userLivre);
        userLivreRepository.save(userLivre);
        userRepository.save(user);
    }





}
