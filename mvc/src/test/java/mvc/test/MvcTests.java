package mvc.test;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import spring.partie6.mvc.ConfigurationMvc;
import spring.partie6.mvc.MvcController;
import spring.partie6.mvc.security.WebSecurityConfig;
import spring.partie6.persistence.dao.ActionRepository;
import spring.partie6.persistence.dao.ApplicationUserRepository;
import spring.partie6.persistence.dao.LivreRepository;
import spring.partie6.persistence.dao.StockRepository;
import spring.partie6.service.LibrairieService;


@WebMvcTest(MvcController.class)
@ContextConfiguration(classes = {ConfigurationMvc.class, WebSecurityConfig.class,MvcController.class,LibrairieService.class})
@ActiveProfiles("default")
public class MvcTests {

   //@MockBean
    //LibrairieService librairieService;

    @MockBean
    LivreRepository livreRepository;
    @MockBean
    StockRepository stockRepository;
    @MockBean
    ApplicationUserRepository applicationUserRepository;
    @MockBean
    ActionRepository actionRepository;


    @Test
    void urlTest(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/")).andExpect(status().isOk());
    }

    @Test
    void securedUrlTestAccessDenied(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/livres")).andExpect(status().is3xxRedirection());
    }

    @Test
    void securedUrlTestUnauthenticatedUserRedirection(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/livres")).andExpect(status().is3xxRedirection());
    }
    @Test
    @WithMockUser(username = "user_name_1", roles = { "utilisateur" })
    void securedUrlTestAccesAllowed(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/livres")).andExpect(status().isOk());
    }
    @Test
    @WithMockUser(username = "user_name_1", roles = { "admin" })
    void securedUrlTestAccesDeniedRoleMissing(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/livres")).andExpect(status().isForbidden());
    }


}
