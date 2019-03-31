package test;

import com.sun.xml.internal.xsom.impl.scd.Iterators;
import library.model.Author;
import library.model.Book;
import library.model.LibraryDAO;
import library.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LibraryDAOTest {
    LibraryDAO model;
    User user1, user2, userNoName, userNoPass;
    Author author1, author2, author3, authorNoFirst, authorNoLast;
    Book book1, book2, book3, bookNoTitle, bookNoDescription, bookNoAuthor;
    ArrayList<Book> books;
    ArrayList<Author> authors;
    ArrayList<User> users;

    @Before
    public void setUp() throws Exception {
        model = LibraryDAO.getInstance();
        user1 = new User("user1", "pass1");
        user2 = new User("user2", "pass2");
        userNoName = new User ();
        userNoName.setPword("pass");
        userNoPass = new User ();
        userNoPass.setUname("user");
        author1 = new Author("Dr.", "Suess");
        author2 = new Author("Mother", "Goose");
        authorNoFirst = new Author();
        authorNoFirst.setLastName("Last");
        authorNoLast = new Author();
        authorNoLast.setFirstName("First");
        book1 = new Book("Hop on Pop", "Elder Abuse");
        book2 = new Book("Goldilocks", "Grand theft breakfast");
        book3 = new Book("Peter Peter Pumpkin Eater", "Kidnapping gourd style");
        bookNoAuthor = new Book();
        bookNoAuthor.setDescription("description");
        bookNoAuthor.setTitle("title");
        bookNoTitle = new Book();
        bookNoTitle.setDescription("nextDesc");
        bookNoDescription = new Book();
        bookNoDescription.setTitle("title new");
        books = new ArrayList<>();
        authors = new ArrayList<>();
        users = new ArrayList<>();
    }

    @After
    public void tearDown() throws Exception {

        if (books != null) {
            for (Book book : books) {
                if (book.getId() != null) {
                    model.deleteObject(book);

                }
            }

        }
        if (authors != null) {
            for (Author author : authors) {
                model.deleteObject(author);
            }
        }


        if (users != null) {
            for (User user : users) {
                if (user.getId() != null) {
                    model.deleteObject(user);
                }
            }

        }
        books.clear();
        authors.clear();
        users.clear();
    }

    @Test
    public void addBook() {
        int expected = 3;
            model.addBook(book1, author1);
            books.add(book1);
            authors.add(author1);
            model.addBook(book2, author2);
            books.add(book2);
            model.addBook(book3,author2);
            books.add(book3);
            authors.add(author2);
            model.addBook(bookNoAuthor, null);
            books.add(bookNoAuthor);
            model.addBook(bookNoTitle, author1);
            books.add((bookNoTitle));
            model.addBook(bookNoDescription, author2);
            books.add((bookNoAuthor));
            int actual = 0;
            for (Book book : books) {
                if (book.getId() != null) {
                    actual ++;
                }
            }
            assertThat(actual, is(expected));
        }


    @Test
    public void addUser() {
        int expected = 2;

        model.addUser(user1);
        users.add(user1);
        model.addUser(user2);
        users.add(user2);
        model.addUser(userNoName);
        users.add(userNoName);
        model.addUser(userNoPass);
        users.add((userNoPass));
        int actual = 0;
        for (User user : users) {
            if (user.getId() != null) {
                actual ++;
            }
        }
        assertEquals(expected, actual);
    }



    @Test
    public void addAuthor() {
        model.addAuthor(author1);
        model.addAuthor(author2);
        model.addAuthor(authorNoFirst);
        model.addAuthor(authorNoLast);
        authors.add(author1);
        authors.add(author2);
        authors.add(authorNoFirst);
        authors.add(authorNoLast);
        int expected = 2;
        int actual = 0;
        for (Author author : authors) {
            if (author.getId() != null) {
                actual ++;
            }
        }
        assertThat(actual, is(expected));
    }

    @Test
    public void getUser() {
        model.addUser(user1);
        users.add(user1);
        User userFromDb = model.getUser("user1", "pass1");
        assertNotNull(userFromDb);
    }



    @Test
    public void getAllBooks() {
        ArrayList<String> addedBooks = new ArrayList<String>();
        model.addBook(book1, author1);
        addedBooks.add(book1.getTitle());
        books.add(book1);
        authors.add(author1);
        model.addBook(book2, author2);
        addedBooks.add(book2.getTitle());
        books.add(book2);
        model.addBook(book3,author2);
        books.add(book3);
        addedBooks.add(book3.getTitle());
        authors.add(author2);
        try {
            ArrayList<Book> booksFromDb = model.getAllBooks();
            ArrayList<String> bookTitles = new ArrayList<>();
            for (Book book : booksFromDb) {
                bookTitles.add(book.getTitle());
            }
            Boolean answer = bookTitles.containsAll(addedBooks);
            assertTrue(answer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAuthor() {
        model.addAuthor(author1);

        authors.add(author1);

        Author foundAuthor = model.getAuthor(author1.getFirstName(), author1.getLastName());
        assertThat(foundAuthor.getFirstName(), is(author1.getFirstName()));
    }
}