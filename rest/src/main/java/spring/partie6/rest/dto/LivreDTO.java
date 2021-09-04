package spring.partie6.rest.dto;

import spring.partie6.persistence.entities.User;

import java.util.HashSet;
import java.util.Set;

public class LivreDTO {

    String nomLivre;

    String nomAuteur;

    private String langue;

    public String getNomLivre() {
        return nomLivre;
    }

    public void setNomLivre(String nomLivre) {
        this.nomLivre = nomLivre;
    }

    public String getNomAuteur() {
        return nomAuteur;
    }

    public void setNomAuteur(String nomAuteur) {
        this.nomAuteur = nomAuteur;
    }


    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getLangue() {
        return langue;
    }
}
