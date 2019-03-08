package store.model;


import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;


/*public class StoreModel {
    private HibernateUtil theHibernateConfiguration;
    public StoreModel() {
        this.theHibernateConfiguration = new HibernateUtil();
    }
    public void addUser(User aUser) {
        Session theSession = this.theHibernateConfiguration.openSession();
        Transaction transaction = theSession.beginTransaction();
        theSession.save(aUser);
        transaction.commit();
    }
    public void updateUser(User aUser){
        Session theSession = this.theHibernateConfiguration.getCurrentSession();
        Transaction transaction = theSession.beginTransaction();
        theSession.merge(aUser);
        transaction.commit();
    }
    public ArrayList getAllUsers(){
        return this.getAll("");
    }
    public ArrayList getAllCustomers() {
        return this.getAll(" where u.manager_level == 0");
    }
    public ArrayList getAllManagers(){
        return this.getAll(" where u.manager_level > 0");
    }
    public ArrayList getAllManagersByLevel(int aLevel) {
        return this.getAll(" where u.manager_level == " + aLevel);
    }
    private ArrayList getAll(String whereClause){
        Session theSession = this.theHibernateConfiguration.getCurrentSession();
        Transaction transaction = theSession.beginTransaction();
        Query allUsersQuery = theSession.createQuery("from store.model.User as u order by u.id" + whereClause);
        List userList = allUsersQuery.list();
        return new ArrayList(userList);
    }

    public User getUser(String aName, String aPassword) {
        Session theSession = this.theHibernateConfiguration.getCurrentSession();
        Transaction transaction = theSession.beginTransaction();
        Query singleUserQuery = theSession.createQuery("from store.model.User as u where u.uname=" + aName+ " and u.pword =" +aPassword);
        User theUser = (User)singleUserQuery.uniqueResult();
        return theUser;
    }
    public User getUserBySessionID(String aSessionID) {
        Session theSession = this.theHibernateConfiguration.getCurrentSession();
        Transaction transaction = theSession.beginTransaction();
        Query singleUserQuery = theSession.createQuery("from store.model.User as u where u.session=" + aSessionID);
        User theUser = (User)singleUserQuery.uniqueResult();
        return theUser;
    }

} */
