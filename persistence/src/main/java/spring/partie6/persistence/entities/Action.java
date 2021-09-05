package spring.partie6.persistence.entities;// default package
// Generated 5 sept. 2021 19:22:55 by Hibernate Tools 6.0.0.Alpha5


import javax.persistence.*;

/**
 * Action generated by hbm2java
 */
@Entity
@Table(name = "action"
        , schema = "public"
)
public class Action implements java.io.Serializable {


    private int id;
    private ApplicationUser applicationUser;

    public Action() {
    }

    public Action(int id, ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }

    @Id  @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    public ApplicationUser getApplicationUser() {
        return this.applicationUser;
    }

    public void setApplicationUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }


}


