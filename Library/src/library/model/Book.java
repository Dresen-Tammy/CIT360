package library.model;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "date_added")
    private LocalDate date_added;

    /*
    * A book has one author, but an author can have many books.
    * ManyToOne with FetchType.EAGER will fetch books when author is called.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    /*
     * A book has one genre, but a genre can have many books.
     * ManyToOne with FetchType.EAGER will fetch books when genre is called.
     */

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;

    /*
    * A book can have many reviews. CascadeType.ALL causes associated
    * reviews to be deleted when a Book is deleted.
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book", fetch = FetchType.EAGER)
    private Set<Review> reviews;

    public Book() {
        this.date_added = LocalDate.now();
    }
    public Book(String title, String description, Author author, Genre genre) {
        this.title = title;
        this.description = description;
        this.date_added = LocalDate.now();
        this.author = author;
        this.genre = genre;
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

    public LocalDate getDate_added() {
        return date_added;
    }

    public void setDate_added(LocalDate date_added) {
        this.date_added = date_added;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date_added=" + date_added +
                ", author=" + author +
                ", genre=" + genre +
                ", reviews=" + reviews +
                '}';
    }
}
