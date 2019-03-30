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
     * Create
     */
    // add object. This works for User, Book and Review
    public void addObject(Object anObject) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(anObject);
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // add object. This works for User, Book and Review
//    public void addBook(Book aBook) {
//        if (aBook != null && aBook.getAuthor() != null && aBook.getDescription() != null &&
//                aBook.getTitle() != null) {
//
//            addObject(aBook);
//        }
//    }

    public void addBook(Book aBook, Author anAuthor) {
        if (aBook != null && aBook.getTitle() != null && aBook.getDescription() != null
                && anAuthor != null && anAuthor.getFirstName() != null && anAuthor.getLastName() != null) {
            Session session = factory.openSession();
            Transaction tx = null;

            try {
                tx = session.beginTransaction();
                session.save(anAuthor);
                aBook.setAuthor(anAuthor);
                session.save(aBook);
                tx.commit();

            } catch (HibernateException e) {
                if (tx != null) {
                    tx.rollback();
                }
                e.printStackTrace();
            } finally {
                session.close();
            }
        }
    }

    public void addAuthor(Author anAuthor) {
        if (anAuthor != null && anAuthor.getFirstName() != null && anAuthor.getLastName() != null) {
            addObject(anAuthor);
        }
    }

    public void addUser(User aUser) {
        if (aUser != null && aUser.getUname() != null && aUser.getPword() != null) {
            addObject(aUser);
        }
    }

    public void deleteObject(Object anObject) {
        if (anObject != null) {
            Session session = factory.openSession();
            Transaction tx = null;

            try {
                tx = session.beginTransaction();
                session.delete(anObject);
                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) {
                    tx.rollback();
                }
                e.printStackTrace();
            } finally {
                session.close();
            }
        }
    }


    // update user. Used for setting new sessionId logging in new session
    public User updateUser(User aUser) {
        if (aUser != null && aUser.getPword() != null && aUser.getUname() != null) {
            Session session = factory.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                session.merge(aUser);
                tx.commit();
                return aUser;
            } catch (HibernateException e) {
                if (tx != null) {
                    tx.rollback();
                }
                e.printStackTrace();
                return null;
            } finally {
                session.close();
            }
        } else {
            return null;
        }
    }


    // get one user by name and password. Used for logging in, returns user.
    public User getUser(String aName, String aPassword) {
        if (aName != null && aPassword != null) {
            Session session = factory.openSession();
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
                if (tx != null) {
                    tx.rollback();
                }
                session.close();
                return null;
            }
        } else {
            return null;
        }
    }

    // get one user by name and password. Used for logging in, returns user.
    public User getUser(String aName) {
        if (aName != null) {
            Session session = factory.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                String sql = "from library.model.User where uname=(:name)";
                Query query = session.createQuery(sql).setParameter("name", aName);
                System.out.println(query);
                User theUser = (User) query.uniqueResult();

                tx.commit();
                session.close();
                return theUser;
            } catch (Exception e) {
                e.printStackTrace();
                if (tx != null) {
                    tx.rollback();
                }
                session.close();
                return null;
            }
        } else {
            return null;
        }

    }


    public ArrayList getAll(String sql) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery(sql);
            List list = query.list();
            tx.commit();
            return new ArrayList(list);
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    /*
     * Query Author table
     */

    // getAllAuthors. Uses getAll to query database.
    public ArrayList getAllAuthors() {
        String sql = "from library.model.Author order by lastName, firstName";
        ArrayList list = getAll(sql);
        return list;
    }

    /*
     * Query Genre table
     */


    /*
     * Query Book table
     */
    // getAllBooks. uses getAll to query databse.
    public ArrayList getAllBooks() {
        String sql = "from library.model.Book order by title";
        ArrayList list = getAll(sql);
        return list;
    }


    // get book by title, author last name
    public Object getBooksByTitleAuthor(String title, String name) {
        if (title != null && name != null) {
            Session session = factory.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                Query query = session.createQuery("from library.model.Book as b inner join library.model.Author as a on b.author = a.id where b.title = (:title) and a.lastName = (:name)");
                query.setParameter("title", title);
                query.setParameter("name", name);
                Object result = query.uniqueResult();
                tx.commit();
                return result;
            } catch (HibernateException e) {
                if (tx != null) {
                    tx.rollback();
                }
                e.printStackTrace();
                return null;
            } finally {
                session.close();
            }
        } else {
            return null;
        }
    }

    public Author getAuthor(String authorFirst, String authorLast) {
        if (authorFirst != null && authorLast != null) {
            Session session = factory.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                Query query = session.createQuery("from Author where lastName= (:authorLast) and firstName = (:authorFirst)");
                query.setParameter("authorLast", authorLast);
                query.setParameter("authorFirst", authorFirst);
                Author author = (Author) query.uniqueResult();
                tx.commit();
                return author;

            } catch (HibernateException e) {
                if (tx != null) {
                    tx.rollback();
                }
                e.printStackTrace();
                return null;
            } finally {
                session.close();
            }
        } else {
            return null;
        }
    }

    /*
     * Query review table
     */


}
