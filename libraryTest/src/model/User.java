package model;

import java.util.Set;

public class User {

    private Integer id;
    private String uname;
    private String pword;
    private int active;
    private int manager_level;
    private String session;


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

}