package store.model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.collection.internal.PersistentBag;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class DAOFile {

    SessionFactory factory = null;
    Session session = null;

    private static DAOFile single_instance = null;

    // constructor. This is private to make it a singleton. Only one instance of it.
    // constructor creates new SessionFactory.
    private DAOFile() {
        factory = HibernateUtil.getSessionFactory();
    }

    // This method is used instead of constructor to only creat one instance of the DAOFile.  If there is not an instance,
    // private constructor is called.  If there is, the single instance is returned.
    public static DAOFile getInstance() {
        if (single_instance == null) {
            single_instance = new DAOFile();
        }
        return single_instance;
    }

    // add User
    public void addUser(User aUser) {
        session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(aUser);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateUser(User aUser) {
        session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge(aUser);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public ArrayList getAllUsers() { return this.getAll("");}
    public ArrayList getAllCustomers() {return this.getAll("");}
    public ArrayList getAllManagers() {return this.getAll("");}
    public ArrayList getAllManagersByLevel() {return this.getAll("");}

    private ArrayList getAll(String whereClause) {
        session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query allUserQuery = session.createQuery("from store.model.User order by id" + whereClause);
            List userList = allUserQuery.list();
            tx.commit();
            return new ArrayList(userList);
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public User getUser(String aName, String aPassword) {
        session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String sql = "from store.model.User where uname=(:name) and pword=(:pass)";
            Query query = session.createQuery(sql).setParameter("name", aName).setParameter("pass", aPassword);
            System.out.println(query);
            User theUser = (User) query.uniqueResult();

            tx.commit();
            session.close();
            return theUser;
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) tx.rollback();
            session.close();
            return null;
        }
    }

    public User getUserBySessionID(String aSessionID) {
        session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query singleUserQuery = session.createQuery("from store.model.User where session=" + aSessionID);
            User theUser = (User)singleUserQuery.uniqueResult();
            tx.commit();
            return theUser;
        } catch (HibernateException e) {
        if (tx != null) tx.rollback();
        e.printStackTrace();
        return null;
    } finally {
        session.close();
    }
    }

}
