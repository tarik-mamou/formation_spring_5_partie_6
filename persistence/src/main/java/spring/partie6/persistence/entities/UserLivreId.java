package spring.partie6.persistence.entities;// default package
// Generated Sep 4, 2021 8:13:52 AM by Hibernate Tools 6.0.0.Alpha5


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UserLivreId generated by hbm2java
 */
@Embeddable
public class UserLivreId  implements java.io.Serializable {


     private int idLivre;
     private int idUser;

    public UserLivreId() {
    }

    public UserLivreId(int idLivre, int idUser) {
       this.idLivre = idLivre;
       this.idUser = idUser;
    }
   


    @Column(name="ID_LIVRE", nullable=false)
    public int getIdLivre() {
        return this.idLivre;
    }
    
    public void setIdLivre(int idLivre) {
        this.idLivre = idLivre;
    }


    @Column(name="ID_USER", nullable=false)
    public int getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UserLivreId) ) return false;
		 UserLivreId castOther = ( UserLivreId ) other; 
         
		 return (this.getIdLivre()==castOther.getIdLivre())
 && (this.getIdUser()==castOther.getIdUser());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdLivre();
         result = 37 * result + this.getIdUser();
         return result;
   }   


}

