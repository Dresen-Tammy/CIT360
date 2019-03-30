package test;

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
    }

    @Test
    public void getUser() {
    }



    @Test
    public void getAllBooks() {
    }

    @Test
    public void getAuthor() {
    }
}