package library.model;

import javax.persistence.*;


import java.util.Date;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "stars")
    private Integer stars;

    @Column(name = "review")
    private String review;

    @Column(name = "date_added")
    private Date date_added;
    /*
    * Each review has one user, but User can have many reviews.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    /*
    * Each Review has one book, but Book can have many reviews.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public Integer getId() { return id;}

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Date getDate_added() {
        return date_added;
    }

    public void setDate_added(Date date_added) {
        this.date_added = date_added;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", stars=" + stars +
                ", review='" + review + '\'' +
                ", date_added=" + date_added +
                '}';
    }
}
