package rest.test;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import spring.partie6.persistence.dao.ActionRepository;
import spring.partie6.persistence.dao.ApplicationUserRepository;
import spring.partie6.persistence.dao.LivreRepository;
import spring.partie6.persistence.dao.StockRepository;
import spring.partie6.persistence.entities.Auteur;
import spring.partie6.persistence.entities.Livre;
import spring.partie6.rest.ConfigurationRest;
import spring.partie6.rest.Controller;
import spring.partie6.rest.security.WebSecurityConfig;
import spring.partie6.service.LibrairieService;
import spring.partie6.service.LibrarieServiceHelper;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(Controller.class)
@ContextConfiguration(classes = {ConfigurationRest.class, WebSecurityConfig.class,Controller.class, LibrairieService.class, LibrarieServiceHelper.class})
public class RestTests {

    @MockBean
    LivreRepository livreRepository;
    @MockBean
    StockRepository stockRepository;
    @MockBean
    ApplicationUserRepository applicationUserRepository;
    @MockBean
    ActionRepository actionRepository;
    @MockBean
    LibrairieService librairieService;

    @Test
    @WithMockUser(username = "user_name_1", roles = { "utilisateur" })
    public void livresRestTest(@Autowired MockMvc mvc) throws Exception {
        Livre livre= new Livre();
        livre.setNom("nomTestLivre");
        livre.setLangue("langueLivre");
        Auteur auteur= new Auteur();
        auteur.setNom("nomTestAuteur");
        livre.setAuteur(auteur);

        Mockito.when(librairieService.chercherLivre(any())).thenReturn(livre);
        mvc.perform(MockMvcRequestBuilders.get("/livresRest"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"nomLivre\":\"nomTestLivre\",\"nomAuteur\":\"nomTestAuteur\",\"langue\":\"langueLivre\"}"));


    }
}
