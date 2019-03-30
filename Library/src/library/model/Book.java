package library.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    // Date added saved for future iteration.
    //@Column(name = "date_added")
    //private LocalDate date_added;

    /*
    * A book has one author, but an author can have many books.
    * ManyToOne with FetchType.EAGER will fetch books when author is called.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    public Book() {

    }

    public Book(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Book(String title, String description, Author author) {
        this.title = title;
        this.description = description;
        this.author = author;
    }


    public Book(Integer id, String title, String description, Author author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public LocalDate getDate_added() {
//        return date_added;
//    }
//
//    public void setDate_added(LocalDate date_added) {
//        this.date_added = date_added;
//    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

//    public Genre getGenre() {
//        return genre;
//    }
//
//    public void setGenre(Genre genre) {
//        this.genre = genre;
//    }

//    public Set<Review> getReviews() {
//        return reviews;
//    }
//
//    public void setReviews(Set<Review> reviews) {
//        this.reviews = reviews;
//    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                //", date_added=" + date_added +
                ", author=" + author +
                //", genre=" + genre +
                //", reviews=" + reviews +
                '}';
    }
}
