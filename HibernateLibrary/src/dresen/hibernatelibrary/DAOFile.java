package dresen.hibernatelibrary;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.*;

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

    /*  CRUD methods that update the objects as well as the database.  */

    // create

    public Integer addBook(String title, String description) {
        session = factory.openSession();
        Transaction tx = null;
        Integer bookId = null;
        try {
            tx = session.beginTransaction();
            Book book = new Book(title, description);
            bookId = (Integer) session.save(book);
            tx.commit();
            return bookId;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

    }

    // read

    public List< Book> getLibrary() {
        session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            String sql = "from dresen.hibernatelibrary.Book";
            List<Book> library = (List<Book>)session.createQuery(sql).getResultList();
            tx.commit();
            return library;
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return null;
        }
        finally {
            session.close();
        }

    }


    public Book getBook(int id) {
     session = factory.openSession();
     Transaction tx = null;
        // create object

     try {
         // start transaction
         tx = session.beginTransaction();
         String sql = "from dresen.hibernatelibrary.Book where id=" + Integer.toString(id);
         // get record
         Book book = (Book)session.createQuery(sql).getSingleResult();
         // commit
         tx.commit();
         return book;
     } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace();
         return null;
     } finally {
         session.close();
     }
    }

    // update
    public Book updateBook(int id, String title, String description) {
        session = factory.openSession();
        Transaction tx = null;
        // start transaction
        try {
            tx = session.beginTransaction();
            String sql = "from dresen.hibernatelibrary.Book where id=" + Integer.toString(id);
            Book book = (Book)session.createQuery(sql).getSingleResult();
            // update the record
            book.setTitle(title);
            book.setDescription(description);
            // commit the transaction
            tx.commit();
            return book;
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    // delete
    public String deleteBook(int id) {
        session = factory.openSession();
        Transaction tx = null;

        // start transaction
        try {
            tx = session.beginTransaction();
            // get record
            String sql = "delete from dresen.hibernatelibrary.Book where id=" + Integer.toString(id);
            // remove record
            session.createQuery(sql).executeUpdate();
            tx.commit();
            return "Book was deleted";
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return  "Book was not deleted";
        } finally {
            session.close();
        }

    }
}
