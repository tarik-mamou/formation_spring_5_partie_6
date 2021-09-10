package spring.partie6.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import spring.partie6.persistence.entities.Livre;
import spring.partie6.rest.Exceptions.LivreNotFoundException;
import spring.partie6.rest.dto.LivreDTO;
import spring.partie6.rest.mapper.LivreMapper;
import spring.partie6.service.LibrairieService;


@RestController
public class Controller {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    LibrairieService librairieService;

    @GetMapping("/livresRest")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<LivreDTO> livresRest(@RequestParam(value = "nomLivre", required = false) String name) {
        Livre livre = librairieService.chercherLivre(name);
        if(livre!= null){
            LivreDTO  livreDTO=LivreMapper.convertToDto(livre);
            return new ResponseEntity<>(
                    livreDTO,
                    HttpStatus.OK);
        }
        throw  new LivreNotFoundException("livre non trouve");
    }

    @GetMapping("/livresRest/all")
    public Iterable<LivreDTO> livresRestAll()  {
        Iterable<Livre> livres = librairieService.findAllLivre();
        Iterable<LivreDTO> livreDTOs = LivreMapper.convertToDtos(livres);
        return livreDTOs;
    }
}