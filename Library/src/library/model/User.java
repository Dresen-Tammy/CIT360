package library.model;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "uname")
    private String uname;
    @Column(name = "pword")
    private String pword;
    @Column(name = "active")
    private int active;
    @Column(name = "manager_level")
    private int manager_level;
    @Column(name = "session")
    private String session;

    /*
    * One user can have many reviews.  CascadeType.All causes associated
    * reviews to be deleted when a user is deleted.
     */

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Review> reviews;


    public User() {
        this.active = 1;
        this.manager_level = 0;
        this.session = "";
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", pword='" + pword + '\'' +
                ", active=" + active +
                ", manager_level=" + manager_level +
                ", session='" + session + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getPword() {
        return pword;
    }
    public void setPword(String pword) {
        this.pword = pword;
    }


    public int getManager_level() {
        return manager_level;
    }

    public void setManager_level(int manager_level) {
        this.manager_level = manager_level;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public void setActive(int anIndicator){
        this.active = anIndicator;
    }

    public int getActive(){
        return this.active;
    }

    public Set<Review> getReviews() {
        return reviews;
    }
}