package spring.partie6.persistence.entities;// default package
// Generated Sep 4, 2021 10:24:16 AM by Hibernate Tools 6.0.0.Alpha5


import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * Livre generated by hbm2java
 */
@Entity
@Table(name="LIVRE"
    ,schema="PUBLIC"
    ,catalog="H2_DATABASE_LIBRAIRE_AVEC_SECURITY"
    , uniqueConstraints = @UniqueConstraint(columnNames="ID_STOCK") 
)
public class Livre  implements java.io.Serializable {


     private int id;
     private Auteur auteur;
     private Profil profil;
     private Stock stock;
     private String nom;
     private String langue;
     private int prix;
    private Set<User> users;

    public Livre() {
    }

	
    public Livre(int id, Auteur auteur, Profil profil, Stock stock, String nom, int prix) {
        this.id = id;
        this.auteur = auteur;
        this.profil = profil;
        this.stock = stock;
        this.nom = nom;
        this.prix = prix;
    }
    public Livre(int id, Auteur auteur, Profil profil, Stock stock, String nom, String langue, int prix) {
       this.id = id;
       this.auteur = auteur;
       this.profil = profil;
       this.stock = stock;
       this.nom = nom;
       this.langue = langue;
       this.prix = prix;
    }
   
     @Id
    @Column(name="ID", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="ID_AUTEUR", nullable=false)
    public Auteur getAuteur() {
        return this.auteur;
    }
    
    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    @OneToOne (cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="ID_PROFILE", nullable=false)
    public Profil getProfil() {
        return this.profil;
    }
    
    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    @OneToOne(fetch=FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="ID_STOCK", unique=true, nullable=false)
    public Stock getStock() {
        return this.stock;
    }
    
    public void setStock(Stock stock) {
        this.stock = stock;
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

    
    @Column(name="PRIX", nullable=false)
    public int getPrix() {
        return this.prix;
    }
    
    public void setPrix(int prix) {
        this.prix = prix;
    }

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "livres")
    public Set<User> users() {
        return this.users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livre livre = (Livre) o;
        return id == livre.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


