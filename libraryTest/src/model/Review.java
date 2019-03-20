package model;

import java.time.LocalDate;
import java.util.Date;

public class Review {

    private Integer id;

    private Integer stars;

    private String review;

    private LocalDate date_added;
    private User user;

    private Book book;

    public Review() {
        this.date_added = LocalDate.now();
    }

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

    public LocalDate getDate_added() {
        return date_added;
    }

    public void setDate_added(LocalDate date_added) {
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
