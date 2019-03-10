package library.model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LibraryDAO {
    // class instance variables
    SessionFactory factory = null;
    Session session = null;

    private static LibraryDAO single_instance = null;

    // constructor. This is private to make it a singleton. Only one instance of it.
    // constructor creates new SessionFactory.
    private LibraryDAO() {
        factory = HibernateUtil.getSessionFactory();
    }

    // This method is used instead of constructor to only creat one instance of the LibraryDAO.  If there is not an instance,
    // private constructor is called.  If there is, the single instance is returned.
    public static LibraryDAO getInstance() {
        if (single_instance == null) {
            single_instance = new LibraryDAO();
        }
        return single_instance;
    }


    /*
    * Query User table
     */

    // add User. Used for registering
    public void addUser(User aUser) {
        session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(aUser);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {tx.rollback();}
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // update user. Used for setting new sessionId logging in new session
    public void updateUser(User aUser) {
        session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge(aUser);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {tx.rollback();}
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    // get one user by name and password. Used for logging in, returns user.
    public User getUser(String aName, String aPassword) {
        session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String sql = "from library.model.User where uname=(:name) and pword=(:pass)";
            Query query = session.createQuery(sql).setParameter("name", aName).setParameter("pass", aPassword);
            System.out.println(query);
            User theUser = (User) query.uniqueResult();

            tx.commit();
            session.close();
            return theUser;
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {tx.rollback();}
            session.close();
            return null;
        }
    }


    // get one user by sessionID. Once logged in, used to maintain session.
    public User getUserBySessionID(String aSessionID) {
        session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String sql = "from library.model.User where session=(:session)";
            Query singleUserQuery = session.createQuery(sql).setParameter("session", aSessionID);
            User theUser = (User)singleUserQuery.uniqueResult();
            tx.commit();
            return theUser;
        } catch (HibernateException e) {
        if (tx != null) {tx.rollback();}
        e.printStackTrace();
        return null;
    } finally {
        session.close();
    }
    }

    /*

    // get all users by their level.  Not implemented.
    public ArrayList getAllUsers() { return this.getAll("");}
    public ArrayList getAllCustomers() {return this.getAll("");}
    public ArrayList getAllManagers() {return this.getAll("");}
    public ArrayList getAllManagersByLevel() {return this.getAll("");}
    */

    /*
    * Query Author table
     */

    public ArrayList getAll(String sql) {
        session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery(sql);
            List list = query.list();
            tx.commit();
            return new ArrayList(list);
        } catch (HibernateException e) {
            if (tx != null) {tx.rollback();}
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    // getAllAuthors. Uses getAll to query database.
    public ArrayList getAllAuthors() {
        String sql = "from library.model.Author order by lastName, firstName";
        ArrayList list = getAll(sql);
        return list;
    }

    /*
     * Query Genre table
     */

    // getAllGenres. Uses getAll to query database.
    public ArrayList getAllGenres() {
        String sql = "from library.model.Genre order by name";
        ArrayList list = getAll(sql);
        return list;
    }

    /*
     * Query Book table
     */
    // getAllBooks. uses getAll to query databse.
    public ArrayList getAllBooks() {
        String sql = "from library.model.Book order by title";
        ArrayList list = getAll(sql);
        return list;
    }

    // add new book.
    public void addBook(Book aBook) {
        session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(aBook);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) { tx.rollback();}
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // get books by author
    public ArrayList getBooksByAuthor(Integer id) {
        session = factory.openSession();
        Transaction tx = null;
        try {
            Query query = session.createQuery("from library.model.Book where author_id = (:author) order by title");
            query.setParameter("author", id);
            List list = query.list();
            tx.commit();
            return new ArrayList(list);
        } catch (HibernateException e) {
            if (tx != null) {tx.rollback();}
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    // get books by genre
    public ArrayList getBooksByGenre(Integer id) {
        session = factory.openSession();
        Transaction tx = null;
        try {
            Query query = session.createQuery("from library.model.Book where genre_id = (:genre) order by title");
            query.setParameter("genre", id);
            List list = query.list();
            tx.commit();
            return new ArrayList(list);
        } catch (HibernateException e) {
            if (tx != null) {tx.rollback();}
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }


    // get book by keyword
    public ArrayList getBooksByKeyWord(String word) {
        session = factory.openSession();
        Transaction tx = null;
        try {
            Query query = session.createQuery("from library.model.Book as b inner join library.model.Author as a on b.author = a.id where b.title like (:word) or a.firstName like (:word) or a.lastName like (:word)");
            query.setParameter("word", word);
            List list = query.list();
            tx.commit();
            return new ArrayList(list);
        } catch (HibernateException e) {
            if (tx != null) { tx.rollback(); }
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
