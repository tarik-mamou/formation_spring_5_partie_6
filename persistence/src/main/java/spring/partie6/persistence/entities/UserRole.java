package spring.partie6.persistence.entities;// default package
// Generated Sep 3, 2021 4:22:08 PM by Hibernate Tools 6.0.0.Alpha5


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UserRole generated by hbm2java
 */
@Entity
@Table(name="USER_ROLE"
    ,schema="PUBLIC"
    ,catalog="H2_DATABASE_LIBRAIRE_AVEC_SECURITY"
)
public class UserRole  implements java.io.Serializable {


     private UserRoleId id;
     private User user;
     private Role role;

    public UserRole() {
    }

	
    public UserRole(UserRoleId id) {
        this.id = id;
    }
    public UserRole(UserRoleId id, User user, Role role) {
       this.id = id;
       this.user = user;
       this.role = role;
    }
   
    @EmbeddedId
    @AttributeOverrides( {
        @AttributeOverride(name="idRole", column=@Column(name="ID_ROLE") ), 
        @AttributeOverride(name="idUser", column=@Column(name="ID_USER") ) } )
    public UserRoleId getId() {
        return this.id;
    }
    
    public void setId(UserRoleId id) {
        this.id = id;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ID_USER", insertable=false, updatable=false)
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ID_ROLE", insertable=false, updatable=false)
    public Role getRole() {
        return this.role;
    }
    
    public void setRole(Role role) {
        this.role = role;
    }




}


