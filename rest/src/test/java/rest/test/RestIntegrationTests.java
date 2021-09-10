package rest.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.FluxExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import spring.partie6.persistence.dao.ActionRepository;
import spring.partie6.persistence.dao.ApplicationUserRepository;
import spring.partie6.persistence.dao.LivreRepository;
import spring.partie6.persistence.dao.StockRepository;
import spring.partie6.rest.ConfigurationRest;
import spring.partie6.rest.Controller;
import spring.partie6.rest.security.WebSecurityConfig;
import spring.partie6.service.LibrairieService;
import spring.partie6.service.LibrarieServiceHelper;

import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@SpringBootTest()
@ContextConfiguration(classes = {ConfigurationRest.class, WebSecurityConfig.class, LibrairieService.class, LibrarieServiceHelper.class})
@EnableAutoConfiguration
public class RestIntegrationTests {
    /*
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

      */
    private WebTestClient webTestClient;


    @Test
    public void livresRestTestNotNull() {
        webTestClient = WebTestClient.bindToServer().baseUrl("http://localhost:8080/livres").build();


       /* this.webTestClient
                .get()
                .uri("/livresRest")
                .exchange()
                .expectStatus()
                .is2xxSuccessful();*/
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/login")
                        .queryParam("username", "user_name_1")
                        .queryParam("password", "pasword1")
                        .build())
                .exchange()
                .expectBody()
                .consumeWith(response ->
                        System.out.println(response.getResponseBody()));
                        //Assertions.assertThat(response.getResponseBody()).isNotNull());
    }

    @Test
    public void livresRestTest() {
        webTestClient = WebTestClient.bindToServer().baseUrl("http://localhost:8080").build();


        FluxExchangeResult<String> result = this.webTestClient
                .post()
                .uri(uriBuilder -> uriBuilder.path("/login")
                        .queryParam("username", "user_name_1")
                        .queryParam("password", "pasword1")
                        .build())
                .exchange()
                .returnResult(String.class);
        // s assuer que le token est renvoyé dans le header
        Map<String, String> map = result.getResponseHeaders().toSingleValueMap();
    }
}
