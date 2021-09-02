package application;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jpa.persistence.dao.LivreRepository;
import jpa.persistence.entities.Livre;

@Service
public class LibrairieService {
    Logger logger = LoggerFactory.getLogger(LibrairieService.class);

    @Autowired
    LivreRepository livreRepository;


   public Iterable<Livre> findAllLivre(){
        return livreRepository.findAll();
    }


   // public List<Livre> findLivre3() {
  //      return jdbcTemplate.query("select * from livre", new BeanRowMapper());
   // }


}
