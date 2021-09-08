package spring.partie6.persistence.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import spring.partie6.persistence.dao.CustomQueriesObjects.LivreProfil;
import spring.partie6.persistence.entities.Livre;

import java.util.List;
import java.util.Optional;

public interface LivreRepository extends PagingAndSortingRepository<Livre, Long> {

    Livre  findByNom(String nom);

    Livre  findByLangue(String langue);

    Livre  findByNomAndLangue(String nom ,String langue);

    Optional<Livre> findByPrix(int prix);

    @Query("select l from Livre l where l.prix = ?1")
    Optional<Livre> rechercherPrix(int prix);

    @Query("select  new spring.partie6.persistence.dao.CustomQueriesObjects.LivreProfil( l.nom, l.prix, l.profil.genre) from Livre l,Profil p where l.profil = p and l.prix=30")
    Optional<LivreProfil> rechercherPrixJoin();

    @Query("select  new spring.partie6.persistence.dao.CustomQueriesObjects.LivreProfil( l.nom, l.prix, l.profil.genre) from Livre l,Profil p where l.profil = p ")
   List<LivreProfil> rechercherPrixJoinList();


}