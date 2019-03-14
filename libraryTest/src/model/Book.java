package model;


import java.time.Instant;
import java.util.Date;
import java.util.Set;

public class Book {


    private Integer id;


    private String title;

    private String description;

    private Date date_added;

    /*
     * A book has one author, but an author can have many books.
     * ManyToOne with FetchType.EAGER will fetch books when author is called.
     */
    private Author author;

    /*
     * A book has one genre, but a genre can have many books.
     * ManyToOne with FetchType.EAGER will fetch books when genre is called.
     */

    private Genre genre;

    /*
     * A book can have many reviews. CascadeType.ALL causes associated
     * reviews to be deleted when a Book is deleted.
     */
    private Set<Review> reviews;


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

    public Date getDate_added() {
        return date_added;
    }

    public void setDate_added(Date date_added) {
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
