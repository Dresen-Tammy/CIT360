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
    @Column(name = "session")
    private String session;

    /*
    * One user can have many reviews.  CascadeType.All causes associated
    * reviews to be deleted when a user is deleted.
     */

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Review> reviews;


    public User() {
        this.session = "";
    }

    public User(String uname, String pword) {
        this.uname = uname;
        this.pword = pword;
        this.session = "";
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", pword='" + pword + '\'' +
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
    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public Set<Review> getReviews() {
        return reviews;
    }
}