package spring.partie6.persistence.entities;// default package
// Generated Sep 3, 2021 4:22:08 PM by Hibernate Tools 6.0.0.Alpha5


import javax.persistence.*;

/**
 * Livre generated by hbm2java
 */
@Entity
@Table(name="LIVRE"
    ,schema="PUBLIC"
    ,catalog="H2_DATABASE_LIBRAIRE_AVEC_SECURITY"
)
public class Livre  implements java.io.Serializable {


     private int id;
     private Auteur auteur;
     private Profil profil;
     private String nom;
     private String langue;

    public Livre() {
    }

	
    public Livre(int id, Auteur auteur, Profil profil, String nom) {
        this.id = id;
        this.auteur = auteur;
        this.profil = profil;
        this.nom = nom;
    }

    public Livre(int id, Auteur auteur, Profil profil, String nom, String langue) {
       this.id = id;
       this.auteur = auteur;
       this.profil = profil;
       this.nom = nom;
       this.langue = langue;
    }
   
     @Id
    @Column(name="ID", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="ID_AUTEUR", nullable=false)
    public Auteur getAuteur() {
        return this.auteur;
    }
    
    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    @OneToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name="ID_PROFILE", nullable=false)
    public Profil getProfil() {
        return this.profil;
    }
    
    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    
    @Column(name="NOM", nullable=false, length=64)
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    
    @Column(name="LANGUE", length=64)
    public String getLangue() {
        return this.langue;
    }
    
    public void setLangue(String langue) {
        this.langue = langue;
    }


}


