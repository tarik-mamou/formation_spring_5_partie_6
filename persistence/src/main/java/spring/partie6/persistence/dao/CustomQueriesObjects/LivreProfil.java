package spring.partie6.persistence.dao.CustomQueriesObjects;

public class LivreProfil {

    String nomLivre;
    Integer prixLivre;
    String genreProfil;

    public LivreProfil(String nomLivre, Integer prixLivre, String genreProfil) {
        this.nomLivre = nomLivre;
        this.prixLivre = prixLivre;
        this.genreProfil = genreProfil;
    }



    public String getNomLivre() {
        return nomLivre;
    }

    public void setNomLivre(String nomLivre) {
        this.nomLivre = nomLivre;
    }

    public Integer getPrixLivre() {
        return prixLivre;
    }

    public void setPrixLivre(Integer prixLivre) {
        this.prixLivre = prixLivre;
    }

    public String getGenreProfil() {
        return genreProfil;
    }

    public void setGenreProfil(String genreProfil) {
        this.genreProfil = genreProfil;
    }




}
