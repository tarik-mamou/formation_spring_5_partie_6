package spring.partie6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import spring.partie6.persistence.dao.ActionRepository;
import spring.partie6.persistence.dao.ApplicationUserRepository;
import spring.partie6.persistence.dao.LivreRepository;
import spring.partie6.persistence.entities.Action;
import spring.partie6.persistence.entities.ApplicationUser;
import spring.partie6.persistence.entities.Livre;

import java.util.Date;

@Service
public class LibrarieServiceHelper {

    @Autowired
    ActionRepository actionRepository;

    @Autowired
    LivreRepository livreRepository;

    @Autowired
    ApplicationUserRepository userRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void acheterLivre(String nomLivre, String nomUser) throws Exception {


        Livre livre = livreRepository.findByNom(nomLivre);

        if (livre == null) {

            throw new Exception("livre nom touvé");
        }

        ApplicationUser user = userRepository.findByUsername(nomUser);
        if (user == null) {

            throw new RuntimeException("user nom touvé");

        }

        user.getLivres().add(livre);
        userRepository.save(user);
    }

   @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void loggerAction(String nomLivre, String nomUser) throws Exception {
        ApplicationUser user = userRepository.findByUsername(nomUser);
        Action action = new Action(user, new Date(), "action 1");
        actionRepository.save(action);
    }
}
